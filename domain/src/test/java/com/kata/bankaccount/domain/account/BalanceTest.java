package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.NegativeWithdrawException;
import com.kata.bankaccount.domain.account.utils.AccountIdMocker;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalanceTest {

    @Test
    public void withdraw_should_throw_an_error_on_negative_withdraw() {
        var balance = new Balance(new BigDecimal(800));


        NegativeWithdrawException exception = assertThrows(
                NegativeWithdrawException.class, () ->
                        balance.subtract(new BigDecimal(-400))
        );

        assertEquals("-400 : Negative withdraws are not allowed", exception.getMessage());
    }
}
