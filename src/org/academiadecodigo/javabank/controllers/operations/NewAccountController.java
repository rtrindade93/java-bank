package org.academiadecodigo.javabank.controllers.operations;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.models.account.AccountType;
import org.academiadecodigo.javabank.views.View;

public class NewAccountController implements Controller {

    private View view;
    private Bank bank;

    public NewAccountController(Bank bank) {
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

    public int openAccount(AccountType accountType) {
        return bank.getCustomer(bank.getAcessingCustomerId()).openAccount(accountType);
    }
}
