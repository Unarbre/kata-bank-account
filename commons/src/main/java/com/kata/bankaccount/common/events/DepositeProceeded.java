package com.kata.bankaccount.common.events;

import com.kata.bankaccount.common.structures.DomainEvent;

import java.math.BigDecimal;

public record DepositeProceeded(String id, BigDecimal amount, BigDecimal newBalance) implements DomainEvent {
}
