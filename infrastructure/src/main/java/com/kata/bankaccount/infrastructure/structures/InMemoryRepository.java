package com.kata.bankaccount.infrastructure.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class InMemoryRepository<E extends IEntity, Id extends String> implements IRepository<E, Id> {

    private final ArrayList<E> entities = new ArrayList<>();

    @Override
    public Optional<E> getById(Id s) {
        return entities.stream()
                .filter(entity -> entity.getId().contentEquals(s))
                .findFirst();
    }

    @Override
    public List<E> getAll() {
        return entities;
    }

    @Override
    public void save(E entity) {
        var entityIndex = this.entities.stream()
                .map(IEntity::getId)
                .collect(Collectors.toList())
                .indexOf(entity.getId());

        if (entityIndex >= 0) {
            this.entities.set(entityIndex, entity);
        } else {
            this.entities.add(entity);
        }
    }

    @Override
    public void delete(Id s) {
        var entityIndex = this.entities.stream()
                .map(IEntity::getId)
                .collect(Collectors.toList())
                .indexOf(s);

        if (entityIndex >= 0) {
            this.entities.remove(entityIndex);
        }
    }
}
