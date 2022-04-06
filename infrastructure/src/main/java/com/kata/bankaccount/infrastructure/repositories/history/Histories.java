package com.kata.bankaccount.infrastructure.repositories.history;

import com.kata.bankaccount.domain.history.IHistories;
import com.kata.bankaccount.domain.history.ReadHistory;
import com.kata.bankaccount.domain.history.WriteHistory;
import com.kata.bankaccount.infrastructure.repositories.history.entities.ReadHistoryAdapter;
import com.kata.bankaccount.infrastructure.repositories.history.entities.WriteHistoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class Histories implements IHistories {

    private final InMemoryHistoryEntityRepository repository;
    private final WriteHistoryAdapter writeHistoryAdapter;
    private final ReadHistoryAdapter readHistoryAdapter;

    @Override
    public String getNextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Optional<ReadHistory> get(String s) {
        return this.repository.getById(s).map(readHistoryAdapter::adapt);
    }

    @Override
    public List<ReadHistory> getAll() {
        return this.repository.getAll()
                .stream()
                .map(readHistoryAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public void save(WriteHistory aggregate) {
        this.repository.save(writeHistoryAdapter.map(aggregate));
    }

    @Override
    public void delete(String aggregateId) {
        this.repository.delete(aggregateId);
    }

    @Override
    public List<ReadHistory> findByAccountId(String accountId) {
        return this.repository.getAll().stream()
                .filter(historyEntity -> historyEntity.accountId().equals(accountId))
                .map(readHistoryAdapter::adapt)
                .collect(Collectors.toList());
    }
}
