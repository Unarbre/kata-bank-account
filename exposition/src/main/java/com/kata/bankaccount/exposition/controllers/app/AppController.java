package com.kata.bankaccount.exposition.controllers.app;

import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class AppController {

    private final Mediator mediator;

    @GetMapping()
    String checkLiveness() {
        return "up";
    }

}
