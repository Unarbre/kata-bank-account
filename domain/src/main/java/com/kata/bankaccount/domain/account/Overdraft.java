package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IValueObject;

import java.math.BigDecimal;

public record Overdraft(BigDecimal value) implements IValueObject {


    public BigDecimal negativeValue() {
        return value.negate();
    }
}
