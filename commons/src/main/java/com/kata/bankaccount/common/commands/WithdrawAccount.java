package com.kata.bankaccount.common.commands;

import io.jkratz.mediator.core.Command;

import java.math.BigDecimal;

public record WithdrawAccount(BigDecimal amount, String accountId) implements Command { }
