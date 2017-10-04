package org.academiadecodigo.javabank.domain;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
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

    public void deposit(int id, double amount) {
        accounts.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accounts.get(id);

        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        account.debit(amount);

    }

    public void transfer(int srcId, int destId, double amount) {

        Account sourceAccount = accounts.get(srcId);
        Account destinationAccount = accounts.get(destId);

        if (sourceAccount.debit(amount)) {
            destinationAccount.credit(amount);
        }
    }

}
