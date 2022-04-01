package com.kata.bankaccount.infrastructure.repositories.account.entities;

import com.kata.bankaccount.domain.account.ReadAccount;
import com.kata.bankaccount.infrastructure.structures.IAdapter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ReadAccountAdapter implements IAdapter<AccountEntity, ReadAccount> {
    @Override
    public ReadAccount adapt(AccountEntity source) {
        return new ReadAccount(source.getId(), source.balance(), source.limit(), source.overdraft(), List.of());
    }
}
