package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class BalanceUnderOverdraftException extends RuntimeException implements DomainException {

    private final String message;


    public BalanceUnderOverdraftException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
