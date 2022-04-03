package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IReadPort;

import java.util.List;

public record ReadHistory() implements IReadPort {

    @Override
    public List<DomainEvent> getEvents() {
        return null;
    }
}
