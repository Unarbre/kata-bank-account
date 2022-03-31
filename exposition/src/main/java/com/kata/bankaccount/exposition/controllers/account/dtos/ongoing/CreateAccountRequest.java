package com.kata.bankaccount.exposition.controllers.account.dtos.ongoing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccountRequest {
    private final String initialBalance;
    private final String initialOverdraft;
    private final String initialLimit;
}