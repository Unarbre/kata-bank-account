package com.kata.bankaccount.domain.structures;

public class MissingPropertyException extends DomainException {
    public MissingPropertyException(String message) {
        super(message);
    }
}
