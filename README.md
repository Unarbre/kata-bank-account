# Bank Account Kata

### Run instruction ###
You may need java 17+ and gradle 7.4.1+ to run this project.

A gradlew has been produce to facilitate version requirement access.

To run the project :
```shell
gradle build && ./gradlew :exposition:bootRun
```

Intellij shall provide a runner on project instantiation, otherwise, the entrypoint is :
`com.kata.bankaccount.exposition.BankAccountApplication`


## Directives
Dans la mesure de votre niveau de séniorité et d'expérience, nous vous proposons de résoudre ce kata avec une architecture hexagonale et en adoptant une routine TDD red/green/refactor.

## Bank Account
Bank account kata Think of your personal bank account experience When in doubt, go for the simplest solution Requirements

·         Deposit and Withdrawal

·         Account statement (date, amount, balance)

·         Statement printing


## User Story 1

In order to save money

As a bank client

I want to make a deposit in my account



## User Story 2

In order to retrieve some or all of my savings

As a bank client

I want to make a withdrawal from my account



## User Story 3

In order to check my operations

As a bank client

I want to see the history (operation, date, amount, balance) of my operations

## Credits
Inspiré par Les teams craftman de la SG CIB

