package com.kata.bankaccount.application.usecases.authentication.query;

import io.jkratz.mediator.core.Request;
import lombok.Builder;

@Builder
public class RegisterUser implements Request<String> {
}
