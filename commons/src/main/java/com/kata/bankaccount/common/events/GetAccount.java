package com.kata.bankaccount.common.events;

import io.jkratz.mediator.core.Request;

public record GetAccount(String accountId) implements Request<String> {

}
