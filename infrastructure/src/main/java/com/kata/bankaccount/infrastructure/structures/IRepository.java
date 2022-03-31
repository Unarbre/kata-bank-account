package com.kata.bankaccount.infrastructure.structures;

import java.util.List;
import java.util.Optional;

public interface IRepository<E extends IEntity, Id> {
    Optional<E> getById(Id id);
    List<E> getAll();
    void save(E entity);
    void delete(Id id);
}
