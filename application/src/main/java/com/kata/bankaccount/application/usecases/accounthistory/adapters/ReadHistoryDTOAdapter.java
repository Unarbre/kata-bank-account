package com.kata.bankaccount.application.usecases.accounthistory.adapters;

import com.kata.bankaccount.application.structures.ReadAdapter;
import com.kata.bankaccount.common.dtos.History;
import com.kata.bankaccount.domain.history.ReadHistory;
import org.springframework.stereotype.Component;

@Component
public class ReadHistoryDTOAdapter implements ReadAdapter<ReadHistory, History> {
    @Override
    public History adapt(ReadHistory source) {
        return new History(source.accountId(), source.newBalance(), source.previousBalance(), source.type().toString(), source.date());
    }
}
