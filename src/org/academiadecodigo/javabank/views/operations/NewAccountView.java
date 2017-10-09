package org.academiadecodigo.javabank.views.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.operations.NewAccountController;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.models.account.AccountType;
import org.academiadecodigo.javabank.views.AbstractView;

public class NewAccountView extends AbstractView {

    private NewAccountController newAccountController;

    public NewAccountView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {
        int accountId = newAccountController.openAccount(AccountType.CHECKING);

        System.out.println("\n" + Messages.CREATED_ACCOUNT + bank.getCustomer(bank.getAcessingCustomerId()).getName() + " : " + accountId);
    }

    @Override
    public void setController(Controller controller) {
        newAccountController = (NewAccountController) controller;
    }
}
