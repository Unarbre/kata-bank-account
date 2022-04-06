package com.kata.bankaccount.exposition.controllers.account.dtos.outgoing;

import com.kata.bankaccount.exposition.structure.ExpositionDTO;

import java.math.BigDecimal;

public record AccountDTO(String accountId,
                         BigDecimal balance,
                         BigDecimal overdraft,
                         BigDecimal limit) implements ExpositionDTO {
}
