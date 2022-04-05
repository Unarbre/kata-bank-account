package com.kata.bankaccount.application.usecases.accounthistory.events;

import com.kata.bankaccount.common.events.WithdrawProceeded;
import com.kata.bankaccount.domain.history.AccountId;
import com.kata.bankaccount.domain.history.History;
import com.kata.bankaccount.domain.history.HistoryId;
import com.kata.bankaccount.domain.history.IHistories;
import io.jkratz.mediator.core.EventHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.kata.bankaccount.domain.history.HistoryType.CREATION;
import static com.kata.bankaccount.domain.history.HistoryType.WITHDRAW;

@Component
@AllArgsConstructor
public class WithdrawProceededHandler implements EventHandler<WithdrawProceeded> {

    private final IHistories histories;

    @Override
    public void handle(@NonNull WithdrawProceeded withdrawProceeded) {
        var history = History.create()
                .accountId(new AccountId(withdrawProceeded.id()))
                .id(new HistoryId(histories.getNextId()))
                .date(LocalDate.now())
                .newBalance(withdrawProceeded.newBalance())
                .previousBalance(withdrawProceeded.newBalance().add(withdrawProceeded.amount()))
                .type(WITHDRAW)
                .build();


        this.histories.save(history.to());

    }
}
