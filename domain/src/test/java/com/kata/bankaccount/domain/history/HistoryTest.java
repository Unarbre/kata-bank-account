package com.kata.bankaccount.domain.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
