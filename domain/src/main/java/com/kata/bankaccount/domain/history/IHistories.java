package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.IReadAggregates;
import com.kata.bankaccount.domain.structures.IWriteAggregates;

public interface IHistories extends IWriteAggregates<WriteHistory, String>, IReadAggregates<ReadHistory, String> {
}
