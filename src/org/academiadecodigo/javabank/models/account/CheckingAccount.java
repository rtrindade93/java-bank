package org.academiadecodigo.javabank.models.account;

public class CheckingAccount extends AbstractAccount {

    public CheckingAccount(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }

}
