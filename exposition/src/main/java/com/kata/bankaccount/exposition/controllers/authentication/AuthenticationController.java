package com.kata.bankaccount.exposition.controllers.authentication;


import com.kata.bankaccount.common.events.RegisterUser;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
@AllArgsConstructor
public class AuthenticationController {

    private final Mediator mediator;

    @GetMapping()
    String getAuthentication() {
        return this.mediator.dispatch(RegisterUser.builder().build());
    }
}
