package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IWritePort;

import java.math.BigDecimal;

public record WriteAccount(String accountId,
                           BigDecimal balance,
                           BigDecimal limit,
                           BigDecimal overdraft) implements IWritePort {
}
