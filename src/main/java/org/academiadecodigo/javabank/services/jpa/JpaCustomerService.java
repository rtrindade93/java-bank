package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerService extends AbstractJpaService<Customer> implements CustomerService {

    public JpaCustomerService(EntityManagerFactory emf) {
        super(emf, Customer.class);
    }

    @Override
    public double getBalance(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            Customer customer = em.find(Customer.class, id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            double balance = 0;
            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            Set<Integer> accountIds = new HashSet<>();

            Customer customer = em.find(Customer.class, id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
