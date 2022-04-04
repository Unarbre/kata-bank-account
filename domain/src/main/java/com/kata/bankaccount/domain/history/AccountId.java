package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.IValueObject;

public record AccountId(String value) implements IValueObject {
}
