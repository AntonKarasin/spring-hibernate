package ru.be_prog.JpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import ru.be_prog.model.Account;
import ru.be_prog.model.Profile;
import ru.be_prog.service.AccountService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountsInitializer {
    private final AccountService accountService;
    private final PlatformTransactionManager txManager;

    @Transactional
    public void createAccounts() {
        accountService.deleteAllAccounts();

        Profile profile1 = new Profile(UUID.randomUUID(), "02-02-2000", "Spain", "Likes ice cream");
        Account account1 = new Account(UUID.randomUUID(), "Steve", "Jobs", profile1);
        accountService.saveAccount(account1);

        Profile profile2 = new Profile(UUID.randomUUID(), "02-02-2001", "Portugal", "Hates ice cream");
        Account account2 = new Account(UUID.randomUUID(), "Bill", "Gates", profile2);
        accountService.saveAccount(account2);

        Profile profile3 = new Profile(UUID.randomUUID(), "02-02-2002", "Spain", "Thinks that pineapple belongs on pizza");
        Account account3 = new Account(UUID.randomUUID(), "James", "Gosling", profile3);
        accountService.saveAccount(account3);

        Profile profile4 = new Profile(UUID.randomUUID(), "02-02-2003", "Russia", "Never uses vpns");
        Account account4 = new Account(UUID.randomUUID(), "Erich", "Gamma", profile4);
        accountService.saveAccount(account4);
    }

    @PostConstruct
    public void init() {
        TransactionTemplate tmpl = new TransactionTemplate(txManager);
        tmpl.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(@NonNull TransactionStatus status) {
                createAccounts();
            }
        });
    }

}
