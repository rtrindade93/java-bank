package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.domain.Customer;

public class GetTotalBalance implements Option {
    @Override
    public void execute(Customer customer) {
        System.out.println("Total Balance: " + customer.getBalance());
    }
}
