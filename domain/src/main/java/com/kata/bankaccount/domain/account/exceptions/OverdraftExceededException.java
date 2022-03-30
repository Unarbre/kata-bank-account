package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class OverdraftExceededException extends DomainException {
    public OverdraftExceededException(String message) {
        super(message);
    }
}
