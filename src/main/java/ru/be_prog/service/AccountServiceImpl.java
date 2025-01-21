package ru.be_prog.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.be_prog.JpaRepository.AccountJpaRepository;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public void saveAccount(Account account) {
        accountJpaRepository.save(account);
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        accountJpaRepository.getReferenceById(account.getId());
        accountJpaRepository.save(account);
    }

    @Override
    public Account findAccountById(UUID id) {

        return accountJpaRepository.getReferenceById(id);
    }

    @Override
    public List<Account> findAllAccounts() {

        return accountJpaRepository.findAll();
    }

    @Override
    public List<Account> findAccountsByCountry(String country) {
        return accountJpaRepository.getAccountsByCountry(country);
    }

    @Override
    public void deleteAccountById(UUID id) {
        accountJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAllAccounts() {
        accountJpaRepository.deleteAll();
    }
}
