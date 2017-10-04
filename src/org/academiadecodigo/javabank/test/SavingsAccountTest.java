package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.AccountType;
import org.academiadecodigo.javabank.domain.SavingsAccount;

public class SavingsAccountTest {

    public boolean test() {

        Account savingsAccount = new SavingsAccount(1);

        // should return SAVINGS
        if(savingsAccount.getAccountType()!=AccountType.SAVINGS) {
            return false;
        }

        return true;
    }
}
