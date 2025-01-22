package ru.be_prog.repository;

import ru.be_prog.model.Account;

import java.util.List;

public interface MyCustomAccountRepository {
    List<Account> getAccountsByCountry(String country);
}
