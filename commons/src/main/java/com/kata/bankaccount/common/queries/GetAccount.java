package com.kata.bankaccount.common.queries;

import io.jkratz.mediator.core.Request;

public record GetAccount(String accountId) implements Request<String> {

}
