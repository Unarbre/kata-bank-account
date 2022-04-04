package com.kata.bankaccount.infrastructure.repositories.history.entities;

import com.kata.bankaccount.domain.history.WriteHistory;
import com.kata.bankaccount.infrastructure.structures.IMapper;
import org.springframework.stereotype.Component;

@Component
public class WriteHistoryAdapter implements IMapper<HistoryEntity, WriteHistory> {

    @Override
    public HistoryEntity map(WriteHistory source) {
        return new HistoryEntity(
                source.id(),
                source.accountId(),
                source.newBalance(),
                source.previousBalance(),
                source.type().toString(),
                source.date()
        );
    }
}
