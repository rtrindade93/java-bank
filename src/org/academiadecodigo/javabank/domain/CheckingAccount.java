package org.academiadecodigo.javabank.domain;

public class CheckingAccount extends Account {

    public CheckingAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
