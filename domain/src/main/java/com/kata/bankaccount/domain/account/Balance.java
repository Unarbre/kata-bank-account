package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.structures.IValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public record Balance(BigDecimal value) implements IValueObject {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(value, balance.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Balance subtract(BigDecimal withdrewAmount) {
        return new Balance(this.value.subtract(withdrewAmount));
    }
}
