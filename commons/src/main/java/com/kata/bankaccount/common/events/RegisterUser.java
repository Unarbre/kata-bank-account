package com.kata.bankaccount.common.events;

import io.jkratz.mediator.core.Request;
import lombok.Builder;

@Builder
public class RegisterUser implements Request<String> {
}
