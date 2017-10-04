package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account {

    private static final int MIN_SAVINGS_BALANCE = 100;

    public SavingsAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public boolean debit(double amount) {
        if(getBalance() < amount + MIN_SAVINGS_BALANCE) {
            return false;
        }

        super.debit(amount);
        return true;
    }
}
