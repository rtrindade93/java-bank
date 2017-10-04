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

        savingsAccount.credit(150);

        // we should not be able to take money making balance under minimum (100)
        savingsAccount.debit(60);
        if(savingsAccount.getBalance() != 150) {
            return false;
        }

        // we should be able to take money from account
        savingsAccount.debit(40);
        if(savingsAccount.getBalance() != 110) {
            return false;
        }

        return true;
    }
}
