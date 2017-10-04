package org.academiadecodigo.javabank.domain.account;

public class SavingsAccount extends Account {

    public static final double MIN_BALANCE = 100;

    public SavingsAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public void debit(double amount) {

        if (getBalance() - amount < MIN_BALANCE) {
            return;
        }

        super.debit(amount);
    }
}
