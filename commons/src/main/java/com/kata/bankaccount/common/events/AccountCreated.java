package com.kata.bankaccount.common.events;

import com.kata.bankaccount.common.structures.DomainEvent;


public record AccountCreated(String id) implements DomainEvent {
}
