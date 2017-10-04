package org.academiadecodigo.javabank.domain.account;

public abstract class Account {

    private int id;
    private double balance = 0;

    public Account(int id) {
        this.id = id;
    }

    public void credit(double amount) {

        if (amount < 0) {
            return;
        }

        balance += amount;
    }

    public void debit(double amount) {

        if (amount < 0) {
            return;
        }

        if (balance >= amount) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public abstract AccountType getAccountType();

    public int getId() {
        return id;
    }
}
