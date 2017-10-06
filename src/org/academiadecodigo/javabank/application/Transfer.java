package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.Set;

public class Transfer implements Option {
    @Override
    public void execute(Customer customer) {
        Set<Integer> accountsNumber = customer.getCustomerAccountsNumber();

        Prompt prompt = new Prompt(System.in, System.out);
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(accountsNumber);
        scanner.setMessage("Choose the source account from your accounts (" + accountsNumber.toString() + ") :");

        int srcID = prompt.getUserInput(scanner);
        
        scanner.setMessage("Choose the destination account from your accounts (" + accountsNumber.toString() + ") :");

        int destID = prompt.getUserInput(scanner);

        DoubleInputScanner amountScanner = new DoubleInputScanner();
        amountScanner.setMessage("Choose amount:");

        double amount = prompt.getUserInput(amountScanner);

        AccountManager accountManager = customer.getAccountManager();

        accountManager.transfer(srcID, destID, amount);
    }
}
