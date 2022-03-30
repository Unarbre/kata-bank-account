package com.kata.bankaccount.domain.user;


import com.kata.bankaccount.domain.structures.IAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class User implements IAggregate<UserId, WriteUser, ReadUser> {
    @Override
    public UserId getId() {
        return null;
    }

    @Override
    public User from(ReadUser source) {
        return null;
    }


    @Override
    public WriteUser to() {
        return null;
    }
}
