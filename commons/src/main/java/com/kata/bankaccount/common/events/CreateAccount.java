package com.kata.bankaccount.common.events;

import io.jkratz.mediator.core.Request;



public record CreateAccount(int initialBalance, int initialOverdraft) implements Request<String> {

}
