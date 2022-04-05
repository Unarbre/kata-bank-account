package com.kata.bankaccount.application.usecases.account.commands;

import com.kata.bankaccount.application.structures.ApplicationException;
import com.kata.bankaccount.common.commands.DepositAccount;
import com.kata.bankaccount.domain.account.Account;
import com.kata.bankaccount.domain.account.IAccounts;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DepositAccountHandler implements CommandHandler<DepositAccount> {

    private final IAccounts accounts;

    @Override
    public void handle(@NonNull DepositAccount depositAccount) {
        var readAccount = accounts.get(depositAccount.accountId())
                .orElseThrow(() -> new ApplicationException(depositAccount.accountId() + " id: no matching account"));

        var account = Account.from(readAccount);


        accounts.save(account.to());
    }
}
