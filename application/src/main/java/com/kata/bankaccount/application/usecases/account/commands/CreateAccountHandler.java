package com.kata.bankaccount.application.usecases.account.commands;

import com.kata.bankaccount.common.events.CreateAccount;
import com.kata.bankaccount.domain.account.Account;
import com.kata.bankaccount.domain.account.AccountId;
import com.kata.bankaccount.domain.account.IAccounts;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateAccountHandler implements RequestHandler<CreateAccount, String> {

    private final IAccounts accounts;

    @Override
    public String handle(@NonNull CreateAccount createAccount) {

        var id = this.accounts.getNextId();

        var account = Account.createBuilder()
                .id(new AccountId(id))
                .initialBalance(createAccount.initialBalance())
                .initialLimit(createAccount.limit())
                .initialOverdraft(createAccount.initialOverdraft())
                .build();

        accounts.save(account.to());

        return id;
    }
}
