package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class OpenAccount implements Option {
    @Override
    public void execute(Customer customer) {
        String[] options = {"Checking Account", "Saving Account"};
        AccountType[] accountTypes = {AccountType.CHECKING, AccountType.SAVINGS};

        Prompt prompt = new Prompt(System.in, System.out);
        MenuInputScanner menuScanner = new MenuInputScanner(options);
        menuScanner.setMessage("Choose an type of account: ");

        int userOption = prompt.getUserInput(menuScanner);

        customer.openAccount(accountTypes[userOption - 1]);
        System.out.println("Account opened");
    }
}
