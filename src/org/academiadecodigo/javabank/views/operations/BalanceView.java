package org.academiadecodigo.javabank.views.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controllers.operations.BalanceController;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.models.Customer;
import org.academiadecodigo.javabank.models.account.Account;
import org.academiadecodigo.javabank.views.AbstractView;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView extends AbstractView {

    private BalanceController balanceController;
    DecimalFormat df = new DecimalFormat("#.##");

    public BalanceView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {
        Customer customer = bank.getCustomer(bank.getAcessingCustomerId());

        System.out.println("\n" + customer.getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));
    }

    @Override
    public void setController(Controller controller) {
        balanceController = (BalanceController) controller;
    }
}
