package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IWritePort;

import java.util.List;

public record WriteHistory() implements IWritePort {



    @Override
    public List<DomainEvent> getEvents() {
        return null;
    }
}
