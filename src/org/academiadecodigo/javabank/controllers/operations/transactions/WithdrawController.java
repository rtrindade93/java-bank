package org.academiadecodigo.javabank.controllers.operations.transactions;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.views.View;

public class WithdrawController implements Controller {

    private View view;
    private Bank bank;

    public WithdrawController(Bank bank) {
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

    public void withdraw(int accountId, double amount) {
        bank.getAccountManager().withdraw(accountId, amount);
    }
}
