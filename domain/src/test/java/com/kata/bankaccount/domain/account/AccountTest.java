package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.BalanceUnderOverdraftException;
import com.kata.bankaccount.domain.account.utils.AccountIdMocker;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {


    @Test
    public void should_create_new_account() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .balance(new Balance(new BigDecimal(500)))
                .overdraft(new Overdraft(new BigDecimal(2000)))
                .limit(new Limit(new BigDecimal(150000)))
                .build();

        assertEquals(account.getBalance(), new Balance(new BigDecimal(500)));
        assertEquals(account.getOverdraft(), new Overdraft(new BigDecimal(2000)));
        assertEquals(account.getLimit(), new Limit(new BigDecimal(150000)));
    }

    @Test
    public void balance_should_not_be_inferior_to_overdraft_limit() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .balance(new Balance(new BigDecimal(-600)))
                                .overdraft(new Overdraft(new BigDecimal(500)))
                                .build()
        );

        assertEquals("-600 balance is under 500 overdraft limit.", exception.getMessage());
    }

    @Test
    public void balance_should_not_exceed_account_limit() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .balance(new Balance(new BigDecimal(9000)))
                                .overdraft(new Overdraft(new BigDecimal(500)))
                                .limit(new Limit(new BigDecimal(8000)))
                                .build()
        );

        assertEquals("9000 balance is over 8000 account limit.", exception.getMessage());
    }


    @Test
    public void should_throw_error_on_create_with_no_id() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .balance(new Balance(new BigDecimal(-600)))
                                .overdraft(new Overdraft(new BigDecimal(500)))
                                .limit(new Limit(new BigDecimal(800)))
                                .build()
        );

        assertEquals("Cannot create Account without an id", exception.getMessage());
    }

    @Test
    public void should_throw_error_on_create_with_no_balance() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .limit(new Limit(new BigDecimal(800)))
                                .overdraft(new Overdraft(new BigDecimal(500)))
                                .build()
        );

        assertEquals("Cannot create Account without an initial Balance", exception.getMessage());
    }

    @Test
    public void should_throw_error_on_create_with_no_overdraft() {
        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .balance(new Balance(new BigDecimal(-600)))
                                .limit(new Limit(new BigDecimal(800)))
                                .build()
        );

        assertEquals("Cannot create Account without an overdraft.", exception.getMessage());
    }

    @Test
    public void withdraw_should_reduce_balance() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .balance(new Balance(new BigDecimal(500)))
                .overdraft(new Overdraft(new BigDecimal(2000)))
                .limit(new Limit(new BigDecimal(150000)))
                .build();


        account.withdraw(400);

        assertEquals(new BigDecimal(100), account.getBalance().value());
    }

    @Test
    public void withdraw_should_throw_an_error_on_negative_withdraw() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .balance(new Balance(new BigDecimal(500)))
                .overdraft(new Overdraft(new BigDecimal(2000)))
                .limit(new Limit(new BigDecimal(150000)))
                .build();


        NegativeWithdrawException exception = assertThrows(
                NegativeWithdrawException.class, () ->
                        account.withdraw(-400)
        );

        assertEquals("-400: Negative withdraws are not allowed", exception.getMessage());
    }

    @Test
    public void withdraw_should_throw_an_error_on_overdraft_exceed() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .balance(new Balance(new BigDecimal(-1800)))
                .overdraft(new Overdraft(new BigDecimal(2000)))
                .limit(new Limit(new BigDecimal(150000)))
                .build();


        OverdraftExceededException exception = assertThrows(
                OverdraftExceededException.class, () ->
                        account.withdraw(300)
        );

        assertEquals("Withdraw 300 impossible. " +
                "Previous Balance : -1800. " +
                "Actual allowed overdraft: 2000.", exception.getMessage());
    }
}
