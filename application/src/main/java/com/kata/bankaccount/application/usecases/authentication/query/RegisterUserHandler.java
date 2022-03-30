package com.kata.bankaccount.application.usecases.authentication.query;

import com.kata.bankaccount.common.events.RegisterUser;
import com.kata.bankaccount.domain.user.IUsers;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterUserHandler implements RequestHandler<RegisterUser, String> {

    private final IUsers users;

    @Override
    public String handle(final RegisterUser registerUser) {
        System.out.println(users.getAll());
        return "a";
    }
}
