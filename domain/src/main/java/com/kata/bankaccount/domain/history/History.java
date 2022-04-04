package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.common.structures.DomainEvent;
import com.kata.bankaccount.domain.structures.IAggregate;
import com.kata.bankaccount.domain.structures.MissingPropertyException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.kata.bankaccount.domain.history.HistoryType.CREATION;
import static com.kata.bankaccount.domain.history.HistoryType.DELETION;

public class History implements IAggregate<HistoryId, WriteHistory, ReadHistory> {

    private final HistoryId id;
    private final AccountId accountId;
    private final Balance newBalance;
    private final Balance previousBalance;
    private final HistoryType type;
    private final HistoryDate date;

    private History(HistoryId id, AccountId accountId, Balance newBalance, Balance previousBalance, HistoryType type, HistoryDate date) {
        this.id = id;
        this.accountId = accountId;
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
        return new WriteHistory(
                id.value(),
                accountId.value(),
                Objects.isNull(newBalance) ? null : newBalance.value(),
                Objects.isNull(previousBalance) ? null : previousBalance.value(),
                type,
                date.value(),
                getEvents()
        );
    }

    @Override
    public List<DomainEvent> getEvents() {
        return List.of();
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

    public static class CreateBuilder {
        private HistoryId id;
        private AccountId accountId;
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

        public CreateBuilder accountId(AccountId accountId) {
            this.accountId = accountId;
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
            if (Objects.isNull(type)) {
                throw new MissingPropertyException("History requires an history type to be created");
            }
            if (Objects.isNull(accountId)) {
                throw new MissingPropertyException("History requires an account id to be created");
            }
            if (Objects.isNull(id)) {
                throw new MissingPropertyException("History requires an id to be created");
            }
            if (Objects.isNull(newBalance) && type != DELETION) {
                throw new MissingPropertyException("History whose type is not deletion requires a new balance to be created");
            }
            if (Objects.isNull(previousBalance) && type != CREATION) {
                throw new MissingPropertyException("History whose type is not creation requires a previous balance to be created");
            }


            return new History(id, accountId, newBalance, previousBalance, type, date);
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
