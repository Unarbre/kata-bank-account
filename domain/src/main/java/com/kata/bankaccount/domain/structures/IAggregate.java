package com.kata.bankaccount.domain.structures;

import com.kata.bankaccount.common.structures.DomainEvent;

import java.util.List;

public interface IAggregate<Id extends IObjectId, Write extends IWritePort, Read extends IReadPort> {

    Id getId();

    Write to();

    List<DomainEvent> getEvents();
}
