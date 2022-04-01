package com.kata.bankaccount.application.usecases.account.aop;


import com.kata.bankaccount.domain.structures.IWritePort;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@AllArgsConstructor
class DomainRepositoryActionHandler {

    private final Mediator mediator;

    @After(value = "execution(* com.kata.bankaccount.domain.structures.IWriteAggregates.save(..)) && args(writePort, ..)")
    private void handleAggregatesModification(IWritePort writePort) {
        for (var event : writePort.getEvents()) {
            System.out.println(event);
            this.mediator.emit(event);
        }
    }
}