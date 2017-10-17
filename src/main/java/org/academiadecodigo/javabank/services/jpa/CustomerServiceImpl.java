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

        try {
            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("CustomerService does not exists");
            }

            return customer;

        } finally {
            transactionManager.commit();
        }

    }

    @Override
    public double getBalance(Integer id) {

        try {
            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("CustomerService does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            double balance = 0;

            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } finally {
            transactionManager.commit();
        }
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        try {

            transactionManager.beginRead();

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                transactionManager.rollback();
                throw new TransactionException("CustomerService does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            Set<Integer> accountIds = new HashSet<>();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;

        } finally {
            transactionManager.commit();
        }
    }
}
