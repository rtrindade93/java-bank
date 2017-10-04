package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.CheckingAccount;

public class AccountTest {

    public boolean test() {

        Account checkingAccount = new CheckingAccount(1);

        // account should start with zero money
        if (checkingAccount.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        checkingAccount.credit(80);
        if (checkingAccount.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from account
        checkingAccount.debit(40);
        if (checkingAccount.getBalance() != 40) {
            return  false;
        }

        return true;
    }

}
