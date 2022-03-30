package com.kata.bankaccount.infrastructure.repositories.user;

import com.kata.bankaccount.domain.user.IUsers;
import com.kata.bankaccount.domain.user.ReadUser;
import com.kata.bankaccount.domain.user.WriteUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Users implements IUsers {
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
