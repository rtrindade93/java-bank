package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class OpenAccount implements Option {
    @Override
    public void execute(Customer customer) {
        customer.openAccount(AccountType.CHECKING);
        System.out.println("Account opened");
    }
}
