package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.BalanceUnderOverdraftException;
import com.kata.bankaccount.domain.account.utils.AccountIdMocker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void balance_should_not_be_inferior_to_overdraft() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .balance(new Balance(-600))
                                .overdraft(new Overdraft(500))
                                .build()
        );

        assertEquals("-600 balance is under 500 overdraft limit.", exception.getMessage());
    }
}
