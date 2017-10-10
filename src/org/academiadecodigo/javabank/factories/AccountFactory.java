package org.academiadecodigo.javabank.factories;

import org.academiadecodigo.javabank.model.account.*;
import org.academiadecodigo.javabank.model.account.CheckingAccount;

public class AccountFactory {

    private int nextAccountId = 1;

    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount(getNextId());
                break;
            case SAVINGS:
                newAccount = new SavingsAccount(getNextId());
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }

    private int getNextId() {
        return nextAccountId++;
    }
}
