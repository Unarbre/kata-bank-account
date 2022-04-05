package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class NegativeDepositeException extends DomainException {
    public NegativeDepositeException(String message) {
        super(message);
    }
}
