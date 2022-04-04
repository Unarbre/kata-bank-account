package com.kata.bankaccount.infrastructure.repositories.history.entities;

import com.kata.bankaccount.infrastructure.structures.IEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HistoryEntity(String id,
                            String accountId,
                            BigDecimal newBalance,
                            BigDecimal previousBalance,
                            String type,
                            LocalDate date) implements IEntity {


    @Override
    public String getId() {
        return id;
    }
}
