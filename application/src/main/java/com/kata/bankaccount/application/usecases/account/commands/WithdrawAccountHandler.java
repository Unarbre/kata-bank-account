package com.kata.bankaccount.application.usecases.account.commands;

import com.kata.bankaccount.application.structures.ApplicationException;
import com.kata.bankaccount.common.commands.WithdrawAccount;
import com.kata.bankaccount.domain.account.Account;
import com.kata.bankaccount.domain.account.IAccounts;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class WithdrawAccountHandler implements CommandHandler<WithdrawAccount> {

    private final IAccounts accounts;

    @Override
    public void handle(@NonNull WithdrawAccount withdrawAccount) {
        var account = accounts.get(withdrawAccount.accountId())
                .orElseThrow(() -> new ApplicationException(withdrawAccount.accountId() + " id: no matching account"));

        var aggregate = Account.from(account);

        aggregate.withdraw(withdrawAccount.amount());

        accounts.save(aggregate.to());
    }
}
