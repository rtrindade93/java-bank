package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customer {

    private String name;
    private int id;
    private AccountManager accountManager;
    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer(String name) {
        this.name = name;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public int openAccount(AccountType accountType) {
        Account account = accountManager.openAccount(accountType);
        accounts.put(account.getId(), account);
        return account.getId();
    }

    public double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    public double getBalance() {

        double balance = 0;

        for (Account account : accounts.values()) {
            balance += account.getBalance();
        }

        return balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getCustomerAccountsNumber() {
        return accounts.keySet();
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }
}
