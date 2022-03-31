package com.kata.bankaccount.infrastructure.repositories.account;

import com.kata.bankaccount.infrastructure.repositories.account.entities.AccountEntity;
import com.kata.bankaccount.infrastructure.structures.InMemoryRepository;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryAccountEntityRepository extends InMemoryRepository<AccountEntity, String> {

}
