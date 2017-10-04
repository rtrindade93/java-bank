package org.academiadecodigo.javabank.domain;

public abstract class Account {

    private double balance = 0;
    private int id;

    public Account(int id) {
        this.id = id;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
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
