package com.kata.bankaccount.exposition.controllers.account.adapters;


import com.kata.bankaccount.common.dtos.Account;
import com.kata.bankaccount.exposition.controllers.account.dtos.outgoing.AccountDTO;
import com.kata.bankaccount.exposition.structure.IExpositionAdapter;
import org.springframework.stereotype.Component;

@Component
public class AccountAdapter implements IExpositionAdapter<Account, AccountDTO> {
    @Override
    public AccountDTO adapt(Account source) {
        return new AccountDTO(source.accountId(), source.balance(), source.overdraft(), source.limit());
    }
}
