package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.Set;

public class Withdraw implements Option {
    @Override
    public void execute(Customer customer) {
        Set<Integer> accountsNumber = customer.getCustomerAccountsNumber();

        Prompt prompt = new Prompt(System.in, System.out);
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(accountsNumber);
        scanner.setMessage("Choose one of your accounts " + accountsNumber.toString() + " :");
        scanner.setError("Invalid account!");

        int accountID = prompt.getUserInput(scanner);
        AccountManager accountManager = customer.getAccountManager();

        DoubleInputScanner amountScanner = new DoubleInputScanner();
        amountScanner.setMessage("Choose amount:");

        double amount = prompt.getUserInput(amountScanner);

        accountManager.withdraw(accountID, amount);
    }
}
