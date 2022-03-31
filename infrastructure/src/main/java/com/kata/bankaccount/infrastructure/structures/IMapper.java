package com.kata.bankaccount.infrastructure.structures;

import com.kata.bankaccount.domain.structures.IWritePort;

public interface IMapper <E extends IEntity, P extends IWritePort>{

    E map(P source);
}
