package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.LogInController;
import org.academiadecodigo.javabank.models.Bank;

public class LogInView extends AbstractView{

    private LogInController logInController;

    public LogInView(Bank bank, Prompt prompt) {
        super(bank, prompt);
    }

    @Override
    public void show() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        logInController.setAccessCustomerId(prompt.getUserInput(scanner));
    }

    public void setController(Controller Controller) {
        this.logInController = (LogInController) Controller;
    }

    public void setLogInController(LogInController logInController) {
        this.logInController = logInController;
    }
}
