package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Application {

    private Bank bank;
    private AccountManager accountManager;
    private Customer customer;
    private Prompt prompt;

    MenuInputScanner menuScanner;
    String[] options = {"Open Account", "Balance", "Deposit", "Withdraw", "Transfer", "Quit"};
    Option[] operations = {new OpenAccount(), new GetBalance(), new Deposit(), new Withdraw(), new Transfer()};

    public Application() {
        prompt = new Prompt(System.in, System.out);

        accountManager = new AccountManager();
        bank = new Bank(accountManager);
        Customer customer1 = new Customer("Miguel");
        Customer customer2 = new Customer("Luis");
        Customer customer3 = new Customer("Joao");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);

        menuScanner = new MenuInputScanner(options);
        menuScanner.setMessage("Choose an option: ");
    }

    public void setCustomer() {
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomersNumber());
        scanner.setMessage("Insert customer number: ");
        scanner.setError("Customer does not exist!");

        customer = bank.getCustomer(prompt.getUserInput(scanner));

        System.out.println("Welcome " + customer.getName());
    }

    public void buildMenu() {

        int userOption = prompt.getUserInput(menuScanner);
        if(userOption != options.length) {
            operations[userOption - 1].execute(customer);

            buildMenu();
        }
    }
}
