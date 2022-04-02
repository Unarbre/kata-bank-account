package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.common.events.AccountCreated;
import com.kata.bankaccount.common.events.WithdrawProceeded;
import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.account.exceptions.BalanceOverLimitException;
import com.kata.bankaccount.domain.account.exceptions.BalanceUnderOverdraftException;
import com.kata.bankaccount.domain.structures.IAggregate;
import com.kata.bankaccount.domain.structures.MissingPropertyException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account implements IAggregate<AccountId, WriteAccount, ReadAccount> {

    private final AccountId id;
    private Balance balance;
    private final Overdraft overdraft;
    private final Limit limit;
    private final ArrayList<DomainEvent> events;

    private Account(AccountId id, Balance balance, Overdraft overdraft, Limit limit, ArrayList<DomainEvent> events) {
        this.id = id;
        this.balance = balance;
        this.overdraft = overdraft;
        this.limit = limit;
        this.events = events;
    }

    public static Account from(ReadAccount source) {
        return new Account(
                new AccountId(source.accountId()),
                new Balance(source.balance()),
                new Overdraft(source.overdraft()),
                new Limit(source.limit()),
                new ArrayList<>());
    }

    @Override
    public WriteAccount to() {
        return new WriteAccount(this.id.value(), this.balance.value(), this.limit.value(), this.overdraft.value(), this.getEvents());
    }

    @Override
    public List<DomainEvent> getEvents() {
        return this.events;
    }

    @Override
    public AccountId getId() {
        return null;
    }

    public Balance getBalance() {
        return new Balance(balance.value());
    }

    public Overdraft getOverdraft() {
        return overdraft;
    }

    public Limit getLimit() {
        return limit;
    }

    public void withdraw(final BigDecimal withdrewAmount) {
        this.balance = this.balance.subtract(withdrewAmount);

        this.applyInvariants();
        this.events.add(new WithdrawProceeded(this.id.value(), withdrewAmount, balance.value()));
    }

    public static AccountCreateBuilder createBuilder() {
        return new AccountCreateBuilder();
    }


    public static class AccountCreateBuilder {
        private Balance balance;
        private Overdraft overdraft;
        private Limit limit;
        private AccountId id;

        public AccountCreateBuilder() {
        }

        public AccountCreateBuilder id(AccountId id) {
            this.id = id;
            return this;
        }

        public AccountCreateBuilder initialBalance(BigDecimal balance) {
            this.balance = new Balance(balance);
            return this;
        }

        public AccountCreateBuilder initialOverdraft(BigDecimal overdraft) {
            this.overdraft = new Overdraft(overdraft);
            return this;
        }

        public AccountCreateBuilder initialLimit(BigDecimal limit) {
            this.limit = new Limit(limit);
            return this;
        }


        public Account build() {
            if (this.id == null) throw new MissingPropertyException("Cannot create Account without an id");
            if (this.balance == null)
                throw new MissingPropertyException("Cannot create Account without an initial Balance");
            if (this.overdraft == null)
                throw new MissingPropertyException("Cannot create Account without an overdraft");

            var account = new Account(
                    id,
                    balance,
                    overdraft,
                    limit,
                    new ArrayList<>());

            account.events.add(new AccountCreated(id.value()));

            account.applyInvariants();
            return account;
        }
    }


     /*
        Invariants
     */

    void applyInvariants() {
        if (isBalanceUnderOverdraftLimit())
            throw new BalanceUnderOverdraftException(this.balance.value() + " balance is under "
                    + this.overdraft.value() + " overdraft limit.");

        if (isBalanceOverLimit()) {
            throw new BalanceOverLimitException(this.balance.value() + " balance is over "
                    + this.limit.value() + " account limit.");
        }
    }

    boolean isBalanceUnderOverdraftLimit() {
        return this.balance.value().compareTo(this.overdraft.value().negate()) < 0;
    }

    boolean isBalanceOverLimit() {
        return this.balance.value().compareTo(this.limit.value()) > 0;
    }


    /*
        Method utils
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id)
                && Objects.equals(balance, account.balance)
                && Objects.equals(overdraft, account.overdraft)
                && Objects.equals(limit, account.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, overdraft, limit);
    }
}
