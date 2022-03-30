package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IValueObject;

import java.math.BigDecimal;

public record Limit(BigDecimal value) implements IValueObject {
}
