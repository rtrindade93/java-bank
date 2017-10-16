package services;

import model.Customer;
import model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerServicePers implements CustomerService {

    private EntityManagerFactory emf;

    @Override
    public Customer add(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Customer savedCustomer = em.merge(customer);
            em.getTransaction().commit(); // close transaction
            return savedCustomer;
        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Customer findById(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Customer.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("from Customer", Customer.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerIds() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Integer> idList = em.createQuery("select id from Customer", Integer.class).getResultList();
            return new HashSet<>(idList);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public double getBalance(int customerId) {
        Customer customer = findById(customerId);
        List<Account> accountList = customer.getAccounts();

        double balance = 0;
        for (Account account : accountList) {
            balance += account.getBalance();
        }

        return balance;
    }

    @Override
    public Set<Integer> getCustomerAccountNumbers(Integer id) {
        Customer customer = findById(id);
        Set<Integer> accountIds = new HashSet<>();
        List<Account> accountList = customer.getAccounts();

        for (Account account : accountList) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
