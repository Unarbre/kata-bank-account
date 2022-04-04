package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.MissingPropertyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static com.kata.bankaccount.domain.history.HistoryType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HistoryTest {


    @Test
    void should_be_created() {
        var id = UUID.randomUUID().toString();
        var now = LocalDate.now();
        var history = History.create()
                .id(new HistoryId(id))
                .accountId(new AccountId(UUID.randomUUID().toString()))
                .previousBalance(new BigDecimal(500))
                .newBalance(new BigDecimal(300))
                .type(WITHDRAW)
                .date(now)
                .build();


        assertEquals(new BigDecimal(500), history.getPreviousBalance().value());
        assertEquals(id, history.getId().value());
        assertEquals(new BigDecimal(300), history.getNewBalance().value());
        assertEquals(now, history.getDate().value());
        assertEquals(WITHDRAW, history.getType());
    }

    @Test
    void should_throw_error_on_empty_type() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .accountId(new AccountId(UUID.randomUUID().toString()))
                        .newBalance(new BigDecimal(1000))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .build()
        );

        assertEquals("History requires an history type to be created", exception.getMessage());
    }

    @Test
    void should_throw_error_on_empty_id() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .accountId(new AccountId(UUID.randomUUID().toString()))
                        .newBalance(new BigDecimal(1000))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History requires an id to be created", exception.getMessage());
    }

    @Test
    void should_throw_error_on_empty_account_id() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .newBalance(new BigDecimal(1000))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History requires an account id to be created", exception.getMessage());
    }

    @Test
    void should_throw_error_on_empty_new_balance_if_type_in_not_deletion() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .accountId(new AccountId(UUID.randomUUID().toString()))
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .previousBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History whose type is not deletion requires a new balance to be created", exception.getMessage());
    }

    @Test
    void should_be_valid_on_empty_new_balance_and_type_equals_deletion() {
        var history = History.create()
                .accountId(new AccountId(UUID.randomUUID().toString()))
                .id(new HistoryId(UUID.randomUUID().toString()))
                .previousBalance(new BigDecimal(1000))
                .date(LocalDate.now())
                .type(DELETION)
                .build();


        assertNull(history.getNewBalance());
    }

    @Test
    void should_throw_error_on_empty_previous_balance_if_type_is_not_creation() {
        MissingPropertyException exception = Assertions.assertThrowsExactly(MissingPropertyException.class,
                () -> History.create()
                        .accountId(new AccountId(UUID.randomUUID().toString()))
                        .id(new HistoryId(UUID.randomUUID().toString()))
                        .newBalance(new BigDecimal(1000))
                        .date(LocalDate.now())
                        .type(WITHDRAW)
                        .build()
        );

        assertEquals("History whose type is not creation requires a previous balance to be created", exception.getMessage());
    }

    @Test
    void should_be_valid_on_empty_previous_balance_on_creation() {
        var history = History.create()
                .accountId(new AccountId(UUID.randomUUID().toString()))
                .id(new HistoryId(UUID.randomUUID().toString()))
                .newBalance(new BigDecimal(1000))
                .date(LocalDate.now())
                .type(CREATION)
                .build();

        assertNull(history.getPreviousBalance());
    }


}
