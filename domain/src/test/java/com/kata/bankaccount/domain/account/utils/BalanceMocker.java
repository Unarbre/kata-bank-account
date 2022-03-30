package com.kata.bankaccount.domain.account.utils;

import com.kata.bankaccount.domain.account.Balance;

public class BalanceMocker {

    public static Balance getValidBalance() {
        return new Balance(300);
    }
}
