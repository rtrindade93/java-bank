package org.academiadecodigo.javabank.controllers.transactions;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.views.View;

public class DepositController implements Controller {

    private View view;
    private Bank bank;

    public DepositController(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void start() {
        view.show();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    public void deposit(int accountId, double amount) {
        bank.getAccountManager().deposit(accountId, amount);
    }
}
