package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account {

    public SavingsAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}
