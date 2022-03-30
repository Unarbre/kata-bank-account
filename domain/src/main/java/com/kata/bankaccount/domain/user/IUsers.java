package com.kata.bankaccount.domain.user;

import com.kata.bankaccount.domain.structures.IReadAggregates;
import com.kata.bankaccount.domain.structures.IWriteAggregates;

public interface IUsers extends IWriteAggregates<WriteUser, String>, IReadAggregates<ReadUser, String> {
}
