package com.kata.bankaccount.domain.structures;

public class DomainException extends RuntimeException {

    private final String message;

    public DomainException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
