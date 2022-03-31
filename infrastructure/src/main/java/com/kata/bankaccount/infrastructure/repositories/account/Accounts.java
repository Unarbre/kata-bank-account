package com.kata.bankaccount.infrastructure.repositories.account;

import com.kata.bankaccount.domain.account.IAccounts;
import com.kata.bankaccount.domain.account.ReadAccount;
import com.kata.bankaccount.domain.account.WriteAccount;
import com.kata.bankaccount.infrastructure.repositories.account.entities.ReadAccountAdapter;
import com.kata.bankaccount.infrastructure.repositories.account.entities.WriteAccountAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;


@AllArgsConstructor
@Repository
public class Accounts implements IAccounts {

    private final InMemoryAccountEntityRepository accountEntityRepository;
    private final ReadAccountAdapter readAccountAdapter;
    private final WriteAccountAdapter writeAccountMapper;

    @Override
    public String getNextId() {
        return "555-" + randomUUID();
    }

    @Override
    public Optional<ReadAccount> get(String s) {
        return this.accountEntityRepository.getById(s).map(this.readAccountAdapter::adapt);
    }

    @Override
    public List<ReadAccount> getAll() {
        return this.accountEntityRepository.getAll()
                .stream()
                .map(readAccountAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public void save(WriteAccount aggregate) {
        this.accountEntityRepository.save(this.writeAccountMapper.map(aggregate));
    }

    @Override
    public void delete(String aggregateId) {

    }
}
