package com.kata.bankaccount.infrastructure.structures;

import com.kata.bankaccount.domain.structures.IReadPort;

public interface IAdapter<E extends IEntity, P extends IReadPort> {
    P adapt(E source);
}
