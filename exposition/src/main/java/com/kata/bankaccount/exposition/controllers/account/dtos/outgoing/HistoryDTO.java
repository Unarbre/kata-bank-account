package com.kata.bankaccount.exposition.controllers.account.dtos.outgoing;

import com.kata.bankaccount.exposition.structure.ExpositionDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HistoryDTO(String accountId,
                         BigDecimal newBalance,
                         BigDecimal previousBalance,
                         String type,
                         LocalDate date) implements ExpositionDTO {
}
