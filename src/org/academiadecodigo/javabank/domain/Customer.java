package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.*;

public class Customer {

    private int id;
    private String name;

    private AccountManager accountManager;
    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer(int id, String name) {
        this.id = id;
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

    public Set<Account> getAccounts() {
        return new HashSet<>(accounts.values());
    }

    public Set<Integer> getAccountIds() {
        return accounts.keySet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}


