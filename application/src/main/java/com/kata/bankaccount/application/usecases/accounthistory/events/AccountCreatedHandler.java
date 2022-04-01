package com.kata.bankaccount.application.usecases.accounthistory.events;

import com.kata.bankaccount.common.events.AccountCreated;
import io.jkratz.mediator.core.EventHandler;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
public class AccountCreatedHandler implements EventHandler<AccountCreated> {
    @Override
    public void handle(@NonNull AccountCreated accountCreated) {

        System.out.println(accountCreated);

    }
}
