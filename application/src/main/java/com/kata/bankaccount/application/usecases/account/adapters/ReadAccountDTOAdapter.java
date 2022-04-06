package com.kata.bankaccount.application.usecases.account.adapters;

import com.kata.bankaccount.application.structures.ReadAdapter;
import com.kata.bankaccount.common.dtos.Account;
import com.kata.bankaccount.domain.account.ReadAccount;
import org.springframework.stereotype.Component;

@Component
public class ReadAccountDTOAdapter implements ReadAdapter<ReadAccount, Account> {
    @Override
    public Account adapt(ReadAccount source) {
        return new Account(source.accountId(), source.balance(), source.overdraft(), source.limit());
    }
}
