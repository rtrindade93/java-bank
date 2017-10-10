package org.academiadecodigo.javabank.views.transactions;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.models.Customer;
import org.academiadecodigo.javabank.views.AbstractView;

public abstract class AbstractAccountTransationView extends AbstractView {

    public AbstractAccountTransationView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {

        if (hasAccounts()) {
            System.out.println("\n" + Messages.OPEN_ACCOUNTS + buildAccountList());
        }

    }

    @Override
    public abstract void setController(Controller controller);

    protected boolean hasAccounts() {
        return bank.getCustomer(bank.getAcessingCustomerId()).getAccountIds().size() > 0;
    }

    protected String buildAccountList() {
        Customer customer = bank.getCustomer(bank.getAcessingCustomerId());

        StringBuilder builder = new StringBuilder();

        for (Integer id : customer.getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    protected int scanAccount() {
        Customer customer = bank.getCustomer(bank.getAcessingCustomerId());

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);

    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.CHOOSE_AMOUNT);
        scanner.setError(Messages.ERROR_INVALID_AMOUNT);

        return prompt.getUserInput(scanner);
    }
}
