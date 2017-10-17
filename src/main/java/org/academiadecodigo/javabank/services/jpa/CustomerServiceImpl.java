package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.exceptions.TransactionException;
import org.academiadecodigo.javabank.managers.TransactionManager;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private TransactionManager transactionManager;
    private CustomerDao customerDao;

    public CustomerServiceImpl(TransactionManager transactionManager, CustomerDao customerDao) {
        this.transactionManager = transactionManager;
        this.customerDao = customerDao;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = null;

        try {
            transactionManager.beginRead();

            customer = customerDao.findById(id);

            if (customer == null) {
                throw new TransactionException("CustomerService does not exists");
            }

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }

        return customer;
    }

    @Override
    public double getBalance(Integer id) {

        double balance = 0;

        try {
            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new TransactionException("CustomerService does not exists");
            }

            List<Account> accounts = customer.getAccounts();


            for (Account account : accounts) {
                balance += account.getBalance();
            }

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }

        return balance;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        Set<Integer> accountIds = new HashSet<>();

        try {

            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new TransactionException("CustomerService does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

        } catch (TransactionException ex) {
            transactionManager.rollback();
        }

        return accountIds;
    }
}
