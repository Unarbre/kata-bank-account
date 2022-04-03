package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.IValueObject;

import java.math.BigDecimal;

public record Balance(BigDecimal value) implements IValueObject {
}
