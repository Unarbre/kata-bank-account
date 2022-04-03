package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IAggregate;
import com.kata.bankaccount.domain.structures.MissingPropertyException;

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
        return this.id;
    }

    @Override
    public WriteHistory to() {
        return null;
    }

    @Override
    public List<DomainEvent> getEvents() {
        return null;
    }

    public Balance getNewBalance() {
        return newBalance;
    }

    public Balance getPreviousBalance() {
        return previousBalance;
    }

    public HistoryDate getDate() {
        return date;
    }

    public HistoryType getType() {
        return type;
    }

    public static CreateBuilder create() {
        return new CreateBuilder();
    }

    static class CreateBuilder {
        private HistoryId id;
        private Balance newBalance;
        private Balance previousBalance;
        private HistoryType type;
        private HistoryDate date;

        public CreateBuilder() {
        }

        public CreateBuilder id(HistoryId id) {
            this.id = id;
            return this;
        }

        public CreateBuilder newBalance(BigDecimal newBalance) {
            this.newBalance = new Balance(newBalance);
            return this;
        }

        public CreateBuilder previousBalance(BigDecimal previousBalance) {
            this.previousBalance = new Balance(previousBalance);
            return this;
        }

        public CreateBuilder type(HistoryType type) {
            this.type = type;
            return this;
        }

        public CreateBuilder date(LocalDate date) {
            this.date = new HistoryDate(date);
            return this;
        }

        public History build() {
            if (Objects.isNull(type)) throw new MissingPropertyException("History require an history type to be created");
            return new History(id, newBalance, previousBalance, type, date);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) &&
                Objects.equals(newBalance, history.newBalance) && Objects.equals(previousBalance, history.previousBalance) && Objects.equals(date, history.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newBalance, previousBalance, type, date);
    }
}