package com.kata.bankaccount.exposition.controllers.account.dtos.ongoing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccountRequest {
    private final Integer initialBalance;
    private final Integer initialOverdraft;
}