package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IObjectId;

public record AccountId(String value) implements IObjectId {
}
