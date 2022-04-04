package com.kata.bankaccount.infrastructure.repositories.history;

import com.kata.bankaccount.infrastructure.repositories.history.entities.HistoryEntity;
import com.kata.bankaccount.infrastructure.structures.InMemoryRepository;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryHistoryEntityRepository extends InMemoryRepository<HistoryEntity, String> { }
