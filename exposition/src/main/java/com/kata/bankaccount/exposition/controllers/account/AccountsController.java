package com.kata.bankaccount.exposition.controllers.account;


import com.kata.bankaccount.common.events.CreateAccount;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.CreateAccountRequest;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class AccountsController {

    private final Mediator mediator;

    @PostMapping()
    void create(@RequestBody CreateAccountRequest createAccountRequest) {
        this.mediator.dispatch(
                new CreateAccount(createAccountRequest.getInitialBalance(),
                createAccountRequest.getInitialOverdraft()
                )
        );
    }
}



