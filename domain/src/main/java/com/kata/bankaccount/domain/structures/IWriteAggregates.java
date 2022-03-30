package com.kata.bankaccount.domain.structures;

public interface IWriteAggregates<Write extends IWritePort, Id> {
    void save(Write aggregate);
    void delete(Id aggregateId);
}
