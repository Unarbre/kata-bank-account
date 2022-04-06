package com.kata.bankaccount.common.dtos;

import com.kata.bankaccount.common.structures.CommonDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public record History(
        String accountId,
        BigDecimal newBalance,
        BigDecimal previousBalance,
        String type,
        LocalDate date) implements CommonDTO {
}
