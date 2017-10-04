package org.academiadecodigo.javabank.domain.account;

public class CheckingAccount extends Account {

    public CheckingAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
