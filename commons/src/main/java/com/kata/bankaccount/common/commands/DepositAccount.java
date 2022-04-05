package com.kata.bankaccount.common.commands;

import io.jkratz.mediator.core.Command;

import java.math.BigDecimal;

public record DepositAccount(String accountId, BigDecimal amount) implements Command {
}
