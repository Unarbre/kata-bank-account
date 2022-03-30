package com.kata.bankaccount.domain.structures;

import java.util.List;

public interface IReadAggregates<Read extends IReadPort, Id>{
    Id getNextId();
    Read get(Id id);
    List<Read> getAll();
}
