package org.academiadecodigo.javabank.views.operations.transactions;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.operations.transactions.WithdrawController;
import org.academiadecodigo.javabank.models.Bank;

public class WithdrawView extends AbstractAccountTransationView {

    private WithdrawController withdrawController;

    public WithdrawView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {
        super.show();

        if (!hasAccounts()) {
            return;
        }

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (bank.getCustomer(bank.getAcessingCustomerId()).getAccountIds().contains(accountId)) {
            withdrawController.withdraw(accountId, amount);
        }
    }

    @Override
    public void setController(Controller controller) {
        withdrawController = (WithdrawController) controller;
    }
}
