package com.kata.bankaccount.domain.account.utils;

import com.kata.bankaccount.domain.account.Balance;

import java.math.BigDecimal;

public class BalanceMocker {

    public static Balance getValidBalance() {
        return new Balance(new BigDecimal(300));
    }
}
