package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.NegativeDepositeException;
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


    @Test
    public void deposit_should_throw_error_on_negative_value() {
        var balance = new Balance(new BigDecimal(800));


        NegativeDepositeException exception = assertThrows(
                NegativeDepositeException.class, () ->
                        balance.add(new BigDecimal(-400))
        );

        assertEquals("-400 : Negative deposites are not allowed", exception.getMessage());
    }
}
