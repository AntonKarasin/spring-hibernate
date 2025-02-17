package ru.be_prog.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface AccountJpaRepository extends JpaRepository<Account, UUID> {
    @Query("select a from Account a inner join Profile p on p.country = ?1 and a.profile.id = p.id")
    List<Account> getAccountsByCountry(String country);
}
