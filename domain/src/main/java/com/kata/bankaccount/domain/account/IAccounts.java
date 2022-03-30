package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IReadAggregates;
import com.kata.bankaccount.domain.structures.IWriteAggregates;

public interface IAccounts extends IWriteAggregates<WriteAccount, String>, IReadAggregates<ReadAccount, String> {
}
