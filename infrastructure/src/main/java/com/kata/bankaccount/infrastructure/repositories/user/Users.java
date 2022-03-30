package com.kata.bankaccount.infrastructure.repositories.user;

import com.kata.bankaccount.domain.user.IUsers;
import com.kata.bankaccount.domain.user.ReadUser;
import com.kata.bankaccount.domain.user.WriteUser;
import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Users implements IUsers {

    private final Mediator mediator;

    @Override
    public ReadUser get(String id) {
        return null;
    }

    @Override
    public List<ReadUser> getAll() {
        return null;
    }

    @Override
    public void save(WriteUser aggregate) {

    }

    @Override
    public void delete(String aggregateId) {

    }
}
