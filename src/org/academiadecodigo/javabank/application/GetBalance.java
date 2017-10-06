package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.domain.Customer;

import java.util.Set;

public class GetBalance implements Option {
    @Override
    public void execute(Customer customer) {
        Set<Integer> accountsNumber = customer.getCustomerAccountsNumber();

        Prompt prompt = new Prompt(System.in, System.out);
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(accountsNumber);
        scanner.setMessage("Choose one of your accounts (" + accountsNumber + ") :");

        System.out.println("Balance: " + customer.getBalance(prompt.getUserInput(scanner)));
    }
}
