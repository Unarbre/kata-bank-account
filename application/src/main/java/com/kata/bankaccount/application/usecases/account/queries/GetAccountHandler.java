package com.kata.bankaccount.application.usecases.account.queries;

import com.kata.bankaccount.application.usecases.account.adapters.ReadAccountDTOAdapter;
import com.kata.bankaccount.common.dtos.Account;
import com.kata.bankaccount.common.queries.GetAccount;
import com.kata.bankaccount.domain.account.IAccounts;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetAccountHandler implements RequestHandler<GetAccount, Optional<Account>> {

    private final IAccounts accounts;
    private final ReadAccountDTOAdapter accountDTOAdapter;

    @Override
    public Optional<Account> handle(@NonNull GetAccount getAccount) {
        return accounts.get(getAccount.accountId()).map(accountDTOAdapter::adapt);
    }
}
