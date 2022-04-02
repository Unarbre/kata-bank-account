package com.kata.bankaccount.application.usecases.accounthistory.events;

import com.kata.bankaccount.common.events.WithdrawProceeded;
import io.jkratz.mediator.core.EventHandler;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class AddWithdrawProceedHistory implements EventHandler<WithdrawProceeded> {
    @Override
    public void handle(@NonNull WithdrawProceeded withdrawProceeded) {
        System.out.println(withdrawProceeded);
    }
}
