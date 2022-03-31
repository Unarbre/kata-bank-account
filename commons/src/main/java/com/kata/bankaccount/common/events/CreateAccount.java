package com.kata.bankaccount.common.events;

import io.jkratz.mediator.core.Request;

import java.math.BigDecimal;


public record CreateAccount(BigDecimal initialBalance, BigDecimal initialOverdraft, BigDecimal limit) implements Request<String> {

}
