package ru.be_prog.JpaRepository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface AccountJpaRepository extends  JpaRepository<Account, UUID>, MyCustomAccountRepository {
    void saveAccount(Account account);

    Account findAccountById(UUID id);

    List<Account> findAllAccounts();

    List<Account> findAccountsByCountry(String country);

    void deleteAccountById(UUID id);

    void deleteAllAccounts();


}
