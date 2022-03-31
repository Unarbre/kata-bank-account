package com.kata.bankaccount.infrastructure.repositories.account.entities;

import com.kata.bankaccount.infrastructure.structures.IEntity;

import java.math.BigDecimal;



public record AccountEntity(String accountId,
                            BigDecimal balance,
                            BigDecimal limit,
                            BigDecimal overdraft) implements IEntity {

    @Override
    public String getId() {
        return accountId;
    }
}
