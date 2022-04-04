package com.kata.bankaccount.infrastructure.repositories.account.entities;

import com.kata.bankaccount.domain.account.WriteAccount;
import com.kata.bankaccount.infrastructure.structures.IMapper;
import org.springframework.stereotype.Component;


@Component
public class WriteAccountMapper implements IMapper<AccountEntity, WriteAccount> {
    @Override
    public AccountEntity map(WriteAccount source) {
        return new AccountEntity(source.accountId(), source.balance(), source.overdraft(), source.limit());
    }
}
