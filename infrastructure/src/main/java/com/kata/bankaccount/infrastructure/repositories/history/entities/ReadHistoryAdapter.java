package com.kata.bankaccount.infrastructure.repositories.history.entities;

import com.kata.bankaccount.domain.history.HistoryType;
import com.kata.bankaccount.domain.history.ReadHistory;
import com.kata.bankaccount.infrastructure.structures.IAdapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ReadHistoryAdapter implements IAdapter<HistoryEntity, ReadHistory> {
    @Override
    public ReadHistory adapt(HistoryEntity source) {
        return new ReadHistory(
                source.id(),
                source.accountId(),
                source.newBalance(),
                source.previousBalance(),
                HistoryType.valueOf(source.type()),
                source.date(),
                new ArrayList<>());
    }
}
