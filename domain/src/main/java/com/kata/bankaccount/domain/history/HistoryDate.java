package com.kata.bankaccount.domain.history;

import com.kata.bankaccount.domain.structures.IValueObject;

import java.time.LocalDate;

public record HistoryDate(LocalDate value) implements IValueObject {
}
