package com.kata.bankaccount.common.dtos;

import com.kata.bankaccount.common.structures.CommonDTO;

import java.math.BigDecimal;

public record Account(String accountId,
                      BigDecimal balance,
                      BigDecimal overdraft,
                      BigDecimal limit) implements CommonDTO {
}
