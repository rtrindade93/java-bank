package model.account;

import model.AbstractModel;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class Account extends AbstractModel {

    private double balance = 0;

    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public abstract AccountType getAccountType();

    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    public boolean canCredit(double amount) {
        return amount > 0;
    }

}
