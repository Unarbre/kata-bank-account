package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IReadPort;

import java.math.BigDecimal;
import java.util.List;

public record ReadAccount(String accountId,
                          BigDecimal balance,
                          BigDecimal limit,
                          BigDecimal overdraft,
                          List<DomainEvent> domainEvents
                          ) implements IReadPort {
    @Override
    public List<DomainEvent> getEvents() {
        return null;
    }
}


