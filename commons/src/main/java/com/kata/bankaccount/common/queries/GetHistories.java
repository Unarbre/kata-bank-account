package com.kata.bankaccount.common.queries;

import com.kata.bankaccount.common.dtos.History;
import io.jkratz.mediator.core.Request;

import java.util.List;

public record GetHistories(String accountId) implements Request<List<History>> {
}
