package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.IReadAggregates;
import com.kata.bankaccount.domain.structures.IWriteAggregates;

import java.util.List;

public interface IHistories extends IWriteAggregates<WriteHistory, String>, IReadAggregates<ReadHistory, String> {
    List<ReadHistory> findByAccountId(String accountId);
}
