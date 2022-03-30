package com.kata.bankaccount.domain.structures;

import java.util.List;

public interface IReadAggregates<Read extends IReadPort, Id>{
    Read get(Id id);
    List<Read> getAll();
}
