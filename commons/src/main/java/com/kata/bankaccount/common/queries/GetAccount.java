package com.kata.bankaccount.common.queries;

import com.kata.bankaccount.common.dtos.Account;
import io.jkratz.mediator.core.Request;

import java.util.Optional;

public record GetAccount(String accountId) implements Request<Optional<Account>> {

}
