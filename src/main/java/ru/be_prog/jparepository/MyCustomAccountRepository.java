package ru.be_prog.JpaRepository;

import ru.be_prog.model.Account;

import java.util.List;

public interface MyCustomAccountRepository {
    List<Account> findAccountsByCountry(String country);
}
