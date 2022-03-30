package com.kata.bankaccount.domain.structures;

public interface IAggregate<Id extends IObjectId, Write extends IWritePort, Read extends IReadPort> {

    Id getId();

    IAggregate<?, ?, ?> from(Read source);

    Write to();
}
