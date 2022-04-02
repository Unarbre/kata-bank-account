package com.kata.bankaccount.application.structures;

public class ApplicationException extends RuntimeException {

    private final String message;

    public ApplicationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
