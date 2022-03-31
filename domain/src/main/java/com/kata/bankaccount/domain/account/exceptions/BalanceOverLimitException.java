package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class BalanceOverLimitException extends DomainException {
    public BalanceOverLimitException(String message) {
        super(message);
    }
}
