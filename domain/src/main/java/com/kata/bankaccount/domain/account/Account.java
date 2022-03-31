package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.BalanceOverLimitException;
import com.kata.bankaccount.domain.account.exceptions.BalanceUnderOverdraftException;
import com.kata.bankaccount.domain.structures.IAggregate;
import com.kata.bankaccount.domain.structures.MissingPropertyException;

import java.math.BigDecimal;
import java.util.Objects;

public class Account implements IAggregate<AccountId, WriteAccount, ReadAccount> {

    private final AccountId id;
    private Balance balance;
    private final Overdraft overdraft;
    private final Limit limit;

    private Account(AccountId id, Balance balance, Overdraft overdraft, Limit limit) {
        this.id = id;
        this.balance = balance;
        this.overdraft = overdraft;
        this.limit = limit;
    }

    @Override
    public Account from(ReadAccount source) {
        return null;
    }

    @Override
    public WriteAccount to() {
        return null;
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
    }

    public static AccountCreateBuilder createBuilder() {
        return new AccountCreateBuilder();
    }


    static class AccountCreateBuilder {
        private Balance balance;
        private Overdraft overdraft;
        private Limit limit;
        private AccountId id;

        public AccountCreateBuilder() {}

        public AccountCreateBuilder id(AccountId id) {
            this.id = id;
            return this;
        }

        public AccountCreateBuilder balance(Balance balance) {
            this.balance = balance;
            return this;
        }

        public AccountCreateBuilder overdraft(Overdraft overdraft) {
            this.overdraft = overdraft;
            return this;
        }

        public AccountCreateBuilder limit(Limit limit) {
            this.limit = limit;
            return this;
        }


        public Account build() {
            if (this.id == null) throw new MissingPropertyException("Cannot create Account without an id");
            if (this.balance == null) throw new MissingPropertyException("Cannot create Account without an initial Balance");
            if (this.overdraft == null) throw new MissingPropertyException("Cannot create Account without an overdraft");

            var account = new Account(id, balance, overdraft, limit);
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
