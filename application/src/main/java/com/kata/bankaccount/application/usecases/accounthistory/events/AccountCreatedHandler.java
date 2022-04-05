package com.kata.bankaccount.application.usecases.accounthistory.events;

import com.kata.bankaccount.common.events.AccountCreated;
import com.kata.bankaccount.domain.history.AccountId;
import com.kata.bankaccount.domain.history.IHistories;
import com.kata.bankaccount.domain.history.History;
import com.kata.bankaccount.domain.history.HistoryId;
import io.jkratz.mediator.core.EventHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.kata.bankaccount.domain.history.HistoryType.CREATION;


@Component
@AllArgsConstructor
public class AccountCreatedHandler implements EventHandler<AccountCreated> {

    private final IHistories histories;

    @Override
    public void handle(@NonNull AccountCreated accountCreated) {
        var history = History.create()
                .accountId(new AccountId(accountCreated.id()))
                .id(new HistoryId(histories.getNextId()))
                .date(LocalDate.now())
                .newBalance(accountCreated.initialBalance())
                .type(CREATION)
                .build();


        this.histories.save(history.to());
    }
}
