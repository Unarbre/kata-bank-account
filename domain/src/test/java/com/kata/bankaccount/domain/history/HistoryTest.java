package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.MissingPropertyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static com.kata.bankaccount.domain.history.HistoryType.WITHDRAW;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {


    @Test
    void should_be_created() {
        var now = LocalDate.now();
        var history = History.create()
                .previousBalance(new BigDecimal(500))
                .newBalance(new BigDecimal(300))
                .type(WITHDRAW)
                .date(now)
                .build();

        assertEquals(new BigDecimal(500), history.getPreviousBalance().value());
        assertEquals(new BigDecimal(300), history.getNewBalance().value());
        assertEquals(now, history.getDate().value());
        assertEquals(WITHDRAW, history.getType());
    }

    @Test
    void should_throw_error_on_empty_type() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .newBalance(new BigDecimal(1000))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .build()
                );

        assertEquals("History require an history type to be created", exception.getMessage());
    }

    @Test
    void should_throw_error_on_empty_id() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .newBalance(new BigDecimal(1000))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History require an id to be created", exception.getMessage());
    }

    @Test
    void should_throw_error_on_empty_new_balance() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History require a new balance to be created", exception.getMessage());
    }
}
