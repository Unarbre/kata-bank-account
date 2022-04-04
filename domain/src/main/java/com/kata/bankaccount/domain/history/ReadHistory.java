package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IReadPort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ReadHistory(String id,
                          String accountId,
                          BigDecimal newBalance,
                          BigDecimal previousBalance,
                          HistoryType type,
                          LocalDate date,
                          List<DomainEvent> events) implements IReadPort {

    @Override
    public List<DomainEvent> getEvents() {
        return events();
    }
}
