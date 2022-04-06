package com.kata.bankaccount.exposition.controllers.account;


import com.kata.bankaccount.common.commands.CreateAccount;
import com.kata.bankaccount.common.commands.DepositAccount;
import com.kata.bankaccount.common.commands.WithdrawAccount;
import com.kata.bankaccount.common.queries.GetAccount;
import com.kata.bankaccount.common.queries.GetHistories;
import com.kata.bankaccount.exposition.controllers.account.adapters.HistoryAdapter;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.CreateAccountRequest;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.DepositeRequest;
import com.kata.bankaccount.exposition.controllers.account.dtos.ongoing.WithdrawRequest;
import com.kata.bankaccount.exposition.controllers.account.dtos.outgoing.HistoryDTO;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor
public class AccountsController {

    private final Mediator mediator;
    private final HistoryAdapter historyAdapter;

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

    @PutMapping("/deposit")
    ResponseEntity<Void> withdraw(@RequestBody DepositeRequest depositeRequest) {
        this.mediator.dispatch(
                new DepositAccount(
                        depositeRequest.getAccountId(),
                        new BigDecimal(depositeRequest.getAmount()))
        );

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/history")
    ResponseEntity<List<HistoryDTO>> getHistories(@PathVariable String id) {
        return ResponseEntity.ok(this.mediator.dispatch(new GetHistories(id)).stream()
                .map(historyAdapter::adapt)
                .collect(Collectors.toList())
        );
    }


    @GetMapping("/{accountId}")
    String getByAccountId(@PathVariable String accountId) {
        return this.mediator.dispatch(
                new GetAccount(accountId)
        );
    }
}



