package com.kata.bankaccount.infrastructure.repositories.account;

import com.kata.bankaccount.domain.account.IAccounts;
import com.kata.bankaccount.domain.account.ReadAccount;
import com.kata.bankaccount.domain.account.WriteAccount;

import java.util.List;

public class Accounts implements IAccounts {
    @Override
    public ReadAccount get(String s) {
        return null;
    }

    @Override
    public List<ReadAccount> getAll() {
        return null;
    }

    @Override
    public void save(WriteAccount aggregate) {

    }

    @Override
    public void delete(String aggregateId) {

    }
}
