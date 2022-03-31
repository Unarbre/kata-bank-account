package com.kata.bankaccount.application.usecases.account.commands;

import com.kata.bankaccount.common.events.GetAccount;
import com.kata.bankaccount.domain.account.IAccounts;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAccountHandler implements RequestHandler<GetAccount, String> {

    private final IAccounts accounts;

    @Override
    public String handle(@NonNull GetAccount getAccount) {
        var account = accounts.get(getAccount.accountId());

        return "oui";

    }
}
