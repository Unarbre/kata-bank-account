package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IAggregate;

class Account implements IAggregate<AccountId, WriteAccount, ReadAccount> {

    private final AccountId id;
    private final Balance balance;
    private final Overdraft overdraft;

    private Account(AccountId id, Balance balance, Overdraft overdraft) {
        this.id = id;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    @Override
    public AccountId getId() {
        return null;
    }

    @Override
    public Account from(ReadAccount source) {
        return null;
    }

    @Override
    public WriteAccount to() {
        return null;
    }
}
