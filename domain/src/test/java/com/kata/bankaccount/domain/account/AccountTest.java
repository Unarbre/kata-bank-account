package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.BalanceOverLimitException;
import com.kata.bankaccount.domain.account.exceptions.BalanceUnderOverdraftException;
import com.kata.bankaccount.domain.account.utils.AccountIdMocker;
import com.kata.bankaccount.domain.structures.MissingPropertyException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {


    @Test
    public void should_create_new_account() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .initialBalance(new BigDecimal(500))
                .initialOverdraft(new BigDecimal(2000))
                .initialLimit(new BigDecimal(150000))
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
                                .initialBalance(new BigDecimal(-600))
                                .initialOverdraft(new BigDecimal(500))
                                .build()
        );

        assertEquals("-600 balance is under 500 overdraft limit.", exception.getMessage());
    }

    @Test
    public void balance_should_not_exceed_account_limit() {
        BalanceOverLimitException exception = assertThrows(
                BalanceOverLimitException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .initialBalance(new BigDecimal(9000))
                                .initialOverdraft(new BigDecimal(500))
                                .initialLimit(new BigDecimal(8000))
                                .build()
        );

        assertEquals("9000 balance is over 8000 account limit.", exception.getMessage());
    }


    @Test
    public void should_throw_error_on_create_with_no_id() {
        MissingPropertyException exception = assertThrows(
                MissingPropertyException.class, () ->
                        Account.createBuilder()
                                .initialBalance(new BigDecimal(-600))
                                .initialOverdraft(new BigDecimal(500))
                                .initialLimit(new BigDecimal(800))
                                .build()
        );

        assertEquals("Cannot create Account without an id", exception.getMessage());
    }

    @Test
    public void should_throw_error_on_create_with_no_balance() {
        MissingPropertyException exception = assertThrows(
                MissingPropertyException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .initialLimit(new BigDecimal(800))
                                .initialOverdraft(new BigDecimal(500))
                                .build()
        );

        assertEquals("Cannot create Account without an initial Balance", exception.getMessage());
    }

    @Test
    public void should_throw_error_on_create_with_no_overdraft() {
        MissingPropertyException exception = assertThrows(
                MissingPropertyException.class, () ->
                        Account.createBuilder()
                                .id(AccountIdMocker.getValidId())
                                .initialBalance(new BigDecimal(-600))
                                .initialLimit(new BigDecimal(800))
                                .build()
        );

        assertEquals("Cannot create Account without an overdraft", exception.getMessage());
    }

    @Test
    public void withdraw_should_reduce_balance() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .initialBalance(new BigDecimal(500))
                .initialOverdraft(new BigDecimal(2000))
                .initialLimit(new BigDecimal(150000))
                .build();


        account.withdraw(new BigDecimal(400));

        assertEquals(new BigDecimal(100), account.getBalance().value());
    }

    @Test
    public void withdraw_should_throw_an_error_on_overdraft_exceed() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .initialBalance(new BigDecimal(-1800))
                .initialOverdraft(new BigDecimal(2000))
                .initialLimit(new BigDecimal(150000))
                .build();


        BalanceUnderOverdraftException exception = assertThrows(
                BalanceUnderOverdraftException.class, () ->
                        account.withdraw(new BigDecimal(300))
        );

        assertEquals("-2100 balance is under 2000 overdraft limit.", exception.getMessage());
    }

    @Test
    public void deposit_should_enlarge_balance() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .initialBalance(new BigDecimal(500))
                .initialOverdraft(new BigDecimal(2000))
                .initialLimit(new BigDecimal(150000))
                .build();


        account.deposit(new BigDecimal(400));

        assertEquals(new BigDecimal(900), account.getBalance().value());
    }

    @Test
    public void deposit_should_throw_error_on_limit_reached() {
        var account = Account.createBuilder()
                .id(AccountIdMocker.getValidId())
                .initialBalance(new BigDecimal(500))
                .initialOverdraft(new BigDecimal(2000))
                .initialLimit(new BigDecimal(600))
                .build();


        BalanceOverLimitException exception = assertThrows(
                BalanceOverLimitException.class, () ->
                        account.deposit(new BigDecimal(400))
        );

        assertEquals("900 balance is over 600 account limit.", exception.getMessage());

    }
}
