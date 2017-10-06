package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bank {

    private AccountManager accountManager;
    private static int numberCustomers = 0;
    private Map<Integer, Customer> customers = new HashMap<>();

    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void addCustomer(Customer customer) {
        numberCustomers++;
        customers.put(numberCustomers, customer);
        customer.setAccountManager(accountManager);
        customer.setId(numberCustomers);
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public  Set<Integer> getCustomersNumber() {
        return customers.keySet();
    }

}
