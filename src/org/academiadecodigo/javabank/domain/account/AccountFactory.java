package org.academiadecodigo.javabank.domain.account;

public class AccountFactory {

    public  Account create(AccountType accountType, int id) {
        switch (accountType) {
            case SAVINGS:
                return new SavingsAccount(id);
            case CHECKING:
                return new CheckingAccount(id);
            default:
                return null;
        }
    }
}
