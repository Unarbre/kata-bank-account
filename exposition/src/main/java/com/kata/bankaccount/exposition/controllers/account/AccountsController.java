package com.kata.bankaccount.exposition.controllers.account;


import com.kata.bankaccount.common.commands.CreateAccount;
import com.kata.bankaccount.common.commands.WithdrawAccount;
import com.kata.bankaccount.common.queries.GetAccount;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.CreateAccountRequest;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.WithdrawRequest;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class AccountsController {

    private final Mediator mediator;

    @PostMapping()
    ResponseEntity<Void> create(@RequestBody CreateAccountRequest createAccountRequest) {
        var id = this.mediator.dispatch(
                new CreateAccount(new BigDecimal(createAccountRequest.getInitialBalance()),
                        new BigDecimal(createAccountRequest.getInitialOverdraft()),
                        new BigDecimal(createAccountRequest.getInitialLimit())
                )
        );

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{accountId}")
                        .buildAndExpand(id)
                        .toUri()
        ).build();

    }

    @PutMapping("/withdraw")
    ResponseEntity<Void> withdraw(@RequestBody WithdrawRequest withdrawRequest) {
        this.mediator.dispatch(
                new WithdrawAccount(new BigDecimal(withdrawRequest.getAmount()),
                        withdrawRequest.getAccountId())
        );

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{accountId}")
    String getByAccountId(@PathVariable String accountId) {
        return this.mediator.dispatch(
                new GetAccount(accountId)
        );
    }
}



