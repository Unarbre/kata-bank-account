package com.kata.bankaccount.application.usecases.account.commands;

import com.kata.bankaccount.common.events.CreateAccount;
import io.jkratz.mediator.core.RequestHandler;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountHandler implements RequestHandler<CreateAccount, String> {
    @Override
    public String handle(@NonNull CreateAccount createAccount) {
        return null;
    }
}
