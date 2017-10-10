package org.academiadecodigo.javabank.views.transactions;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.transactions.DepositController;
import org.academiadecodigo.javabank.models.Bank;

public class DepositView extends AbstractAccountTransationView {

    private DepositController depositController;

    public DepositView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {

        if (!hasAccounts()) {
            System.out.println("\n" + Messages.ERROR_NO_ACCOUNT);
            return;
        }

        super.show();

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (bank.getCustomer(bank.getAcessingCustomerId()).getAccountIds().contains(accountId)) {
            depositController.deposit(accountId, amount);
        }
    }

    @Override
    public void setController(Controller controller) {
        depositController = (DepositController) controller;
    }
}
