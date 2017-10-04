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

        return true;
    }
}