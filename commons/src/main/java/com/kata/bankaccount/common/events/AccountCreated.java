package com.kata.bankaccount.common.events;

import com.kata.bankaccount.common.structures.DomainEvent;

import java.math.BigDecimal;


public record AccountCreated(String id, BigDecimal initialBalance) implements DomainEvent {
}
