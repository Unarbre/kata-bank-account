package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IWritePort;

import java.math.BigDecimal;
import java.util.List;

public record WriteAccount(String accountId,
                           BigDecimal balance,
                           BigDecimal limit,
                           BigDecimal overdraft,
                           List<DomainEvent> events
                           ) implements IWritePort {


    @Override
    public List<DomainEvent> getEvents() {
        return events();
    }
}
