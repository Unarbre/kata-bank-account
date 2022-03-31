package com.kata.bankaccount.domain.structures;

import java.util.List;
import java.util.Optional;

public interface IReadAggregates<Read extends IReadPort, Id>{
    Id getNextId();
    Optional<Read> get(Id id);
    List<Read> getAll();
}
