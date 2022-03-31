package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IReadPort;

import java.math.BigDecimal;

public record ReadAccount(String accountId,
                          BigDecimal balance,
                          BigDecimal limit,
                          BigDecimal overdraft
                          ) implements IReadPort {
}


