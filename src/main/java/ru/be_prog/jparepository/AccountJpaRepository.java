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
    // void saveAccount(Account account);

    // Account getReferenceById(UUID id);

    // List<Account> findAll();

    List<Account> getAccountsByCountry(String country);

    // void deleteById(UUID id);

    // void deleteAllAccounts();


}
