package com.kata.bankaccount.exposition.controllers.account.adapters;

import com.kata.bankaccount.common.dtos.History;
import com.kata.bankaccount.exposition.controllers.account.dtos.outgoing.HistoryDTO;
import com.kata.bankaccount.exposition.structure.IExpositionAdapter;
import org.springframework.stereotype.Component;


@Component
public class HistoryAdapter implements IExpositionAdapter<History, HistoryDTO> {
    @Override
    public HistoryDTO adapt(History source) {
        return new HistoryDTO(
                source.accountId(),
                source.newBalance(),
                source.previousBalance(),
                source.type(),
                source.date());
    }
}
