package com.kata.bankaccount.domain.account.exceptions;

import com.kata.bankaccount.domain.structures.DomainException;

public class NegativeWithdrawException extends DomainException {
    public NegativeWithdrawException(String message) {
        super(message);
    }
}
