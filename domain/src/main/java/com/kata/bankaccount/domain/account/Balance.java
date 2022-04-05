package com.kata.bankaccount.domain.account;

import com.kata.bankaccount.domain.account.exceptions.NegativeDepositeException;
import com.kata.bankaccount.domain.account.exceptions.NegativeWithdrawException;
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
        if (withdrewAmount.compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeWithdrawException(withdrewAmount + " : Negative withdraws are not allowed");

        return new Balance(this.value.subtract(withdrewAmount));
    }

    public Balance add(BigDecimal depositAmount) {
        if (depositAmount.compareTo(BigDecimal.ZERO) < 0)
            throw new NegativeDepositeException(depositAmount + " : Negative deposites are not allowed");

        return new Balance(this.value.add(depositAmount));
    }
}
