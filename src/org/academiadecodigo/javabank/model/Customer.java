package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

import java.util.*;

public class Customer {

    private int id;
    private String name;

    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
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


