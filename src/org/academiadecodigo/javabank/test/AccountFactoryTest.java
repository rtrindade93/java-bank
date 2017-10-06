package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountFactory;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class AccountFactoryTest {
    public boolean test() {

        AccountFactory accountFactory = new AccountFactory();

        // should create a savings account
        Account savingsAccount = accountFactory.create(AccountType.SAVINGS, 1);
        if (savingsAccount.getAccountType() != AccountType.SAVINGS) {
            return false;
        }

        // should create a checking account
        Account checkingAccount = accountFactory.create(AccountType.CHECKING, 2);
        if ( checkingAccount.getAccountType() != AccountType.CHECKING) {
            return false;
        }

        return true;
    }
}
