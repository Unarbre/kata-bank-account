package com.kata.bankaccount.exposition.controllers.account;


import com.kata.bankaccount.common.events.CreateAccount;
import com.kata.bankaccount.common.events.GetAccount;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.CreateAccountRequest;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class AccountsController {

    private final Mediator mediator;

    @PostMapping()
    void create(@RequestBody CreateAccountRequest createAccountRequest) {
        var id = this.mediator.dispatch(
                new CreateAccount(new BigDecimal(createAccountRequest.getInitialBalance()),
                        new BigDecimal(createAccountRequest.getInitialOverdraft()),
                        new BigDecimal(createAccountRequest.getInitialLimit())
                )
        );
    }


    @GetMapping("/{accountId}")
    String getByAccountId(@PathVariable String accountId) {
        return this.mediator.dispatch(
                new GetAccount(accountId)
        );
    }
}



