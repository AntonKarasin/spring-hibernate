package ru.be_prog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.be_prog.configuration.HibernateConfiguration;
import ru.be_prog.model.Account;
import ru.be_prog.model.Profile;
import ru.be_prog.service.AccountService;

import java.util.List;
import java.util.UUID;

public class SpringHibernateApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);

        AccountService accountService = context.getBean(AccountService.class);

        // Сначала мы очищаем таблицу аккаунтов
        accountService.deleteAllAccounts();

        // Создаем 4 аккаунта
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

        // Получаем все аккаунты из базы и выводим на экран
        List<Account> allAccounts = accountService.findAllAccounts();
        for (Account account: allAccounts) {
            System.out.println(account);
        }

        List<Account> allSpainAccounts = accountService.findAccountsByCountry("Spain");
        for (Account account: allSpainAccounts) {
            System.out.println(account);
        }
    }
}
