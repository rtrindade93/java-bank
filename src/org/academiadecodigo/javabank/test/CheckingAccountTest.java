package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.AccountType;
import org.academiadecodigo.javabank.domain.CheckingAccount;

public class CheckingAccountTest {

    public boolean test() {

        CheckingAccount checkingAccount = new CheckingAccount(1);

        // should return CHECKING
        if(checkingAccount.getAccountType() != AccountType.CHECKING){
            return false;
        }

        checkingAccount.credit(80);

        // we should be able to take money from account
        checkingAccount.debit(40);
        if (checkingAccount.getBalance() != 40) {
            return  false;
        }

        // we should not be able to take more money than the account has
        checkingAccount.debit(50);
        if (checkingAccount.getBalance() != 40) {
            return  false;
        }

        return true;
    }
}