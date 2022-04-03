package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IAggregate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class History implements IAggregate<HistoryId, WriteHistory, ReadHistory> {

    private final HistoryId id;
    private final Balance newBalance;
    private final Balance previousBalance;
    private final HistoryType type;
    private final HistoryDate date;

    private History(HistoryId id, Balance newBalance, Balance previousBalance, HistoryType type, HistoryDate date) {
        this.id = id;
        this.newBalance = newBalance;
        this.previousBalance = previousBalance;
        this.type = type;
        this.date = date;
    }

    @Override
    public HistoryId getId() {
        return null;
    }

    @Override
    public WriteHistory to() {
        return null;
    }

    @Override
    public List<DomainEvent> getEvents() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) && Objects.equals(newBalance, history.newBalance) && Objects.equals(previousBalance, history.previousBalance) && Objects.equals(historyDate, history.historyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newBalance, previousBalance, type, date);
    }
}
