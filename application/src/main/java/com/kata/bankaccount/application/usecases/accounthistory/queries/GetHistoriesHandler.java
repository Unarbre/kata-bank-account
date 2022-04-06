package com.kata.bankaccount.application.usecases.accounthistory.queries;

import com.kata.bankaccount.application.usecases.accounthistory.adapters.ReadHistoryDTOAdapter;
import com.kata.bankaccount.common.dtos.History;
import com.kata.bankaccount.common.queries.GetHistories;
import com.kata.bankaccount.domain.history.IHistories;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class GetHistoriesHandler implements RequestHandler<GetHistories, List<History>> {

    private final IHistories histories;
    private final ReadHistoryDTOAdapter adapter;

    @Override
    public List<History> handle(@NonNull GetHistories getHistories) {
        return histories.findByAccountId(getHistories.accountId())
                .stream()
                .map(adapter::adapt)
                .collect(Collectors.toList());
    }
}
