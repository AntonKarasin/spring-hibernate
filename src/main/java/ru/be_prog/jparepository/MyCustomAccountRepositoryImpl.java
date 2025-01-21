package ru.be_prog.JpaRepository;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.be_prog.model.Account;

import java.util.List;

@Transactional
@RequiredArgsConstructor
public class MyCustomAccountRepositoryImpl implements MyCustomAccountRepository {
    @Autowired
    private final SessionFactory sessionFactory;
    @Override
    public List<Account> findAccountsByCountry(String country) {
        TypedQuery<Account> query = sessionFactory.getCurrentSession().createQuery(
                "select a from Account a, Profile p where p.country = ?1 and a.profile.id = p.id", Account.class
        );
        query.setParameter(1, country);
        return query.getResultList();
    }
}
