package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.views.View;

public class LogInController implements Controller{

    private Controller nextController;
    private View view;
    private Bank bank;

    public LogInController(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void start() {
        view.show();
    }

    public void setNextController(Controller controller) {
        nextController = controller;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    public void setLogInView(View logInView) {
        this.view = logInView;
    }

    public void setAccessCustomerId(int id) {
        bank.setAcessingCustomerId(id);
        nextController.start();
    }
}
