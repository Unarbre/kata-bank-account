package com.kata.bankaccount.domain.structures;

import com.kata.bankaccount.common.structures.DomainEvent;

import java.util.List;

public interface IPort {

    List<DomainEvent> getEvents();
}
