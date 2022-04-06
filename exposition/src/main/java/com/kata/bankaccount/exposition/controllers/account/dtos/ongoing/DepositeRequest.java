package com.kata.bankaccount.exposition.controllers.account.dtos.ongoing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DepositeRequest {
    private final String accountId;
    private final String amount;
}
