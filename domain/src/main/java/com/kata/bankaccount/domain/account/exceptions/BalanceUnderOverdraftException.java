package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class BalanceUnderOverdraftException extends DomainException {

    public BalanceUnderOverdraftException(String message) {
        super(message);
    }
}
