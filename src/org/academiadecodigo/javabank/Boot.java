package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controllers.BalanceController;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.LogInController;
import org.academiadecodigo.javabank.controllers.MainMenuController;
import org.academiadecodigo.javabank.controllers.NewAccountController;
import org.academiadecodigo.javabank.controllers.transactions.DepositController;
import org.academiadecodigo.javabank.controllers.transactions.WithdrawController;
import org.academiadecodigo.javabank.models.Bank;
import org.academiadecodigo.javabank.models.Customer;
import org.academiadecodigo.javabank.models.managers.AccountManager;
import org.academiadecodigo.javabank.views.BalanceView;
import org.academiadecodigo.javabank.views.LogInView;
import org.academiadecodigo.javabank.views.MainMenuView;
import org.academiadecodigo.javabank.views.NewAccountView;
import org.academiadecodigo.javabank.views.transactions.DepositView;
import org.academiadecodigo.javabank.views.transactions.WithdrawView;

import java.util.HashMap;
import java.util.Map;

public class Boot {

    private Bank bank;
    private Prompt prompt;
    //Controllers
    private LogInController logInController;
    private MainMenuController mainMenuController;
    private BalanceController balanceController;
    private DepositController depositController;
    private WithdrawController withdrawController;
    private NewAccountController newAccountController;
    //Views
    private LogInView logInView;
    private MainMenuView mainMenuView;
    private BalanceView balanceView;
    private DepositView depositView;
    private WithdrawView withdrawView;
    private NewAccountView newAccountView;

    public Boot() {
        bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);
        prompt = new Prompt(System.in, System.out);
    }

    public void start() {
        logInController.start();
    }

    public void generateData() {
        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);
    }

    public void makeConnections(){

        logInController = new LogInController(bank);
        logInView = new LogInView(bank, prompt);
        //connect LogInController and LogInView
        logInController.setLogInView(logInView);
        logInView.setLogInController(logInController);

        mainMenuController = new MainMenuController();
        mainMenuView = new MainMenuView(bank, prompt);
        //Connect LogInController and MainMenuController
        logInController.setNextController(mainMenuController);
        //Connect MainMenuController and MainMenuView
        mainMenuController.setView(mainMenuView);
        mainMenuView.setController(mainMenuController);

        balanceController = new BalanceController();
        balanceView = new BalanceView(bank, prompt);
        //Connect BalanceController and BalanceView
        balanceController.setView(balanceView);
        balanceView.setController(balanceController);

        depositController = new DepositController(bank);
        depositView = new DepositView(bank, prompt);
        //Connect DepositController and DepositView
        depositController.setView(depositView);
        depositView.setController(depositController);

        withdrawController = new WithdrawController(bank);
        withdrawView = new WithdrawView(bank, prompt);
        //Connect WithdrawController and WithdrawView
        withdrawController.setView(withdrawView);
        withdrawView.setController(withdrawController);

        newAccountController = new NewAccountController(bank);
        newAccountView = new NewAccountView(bank, prompt);
        //Connect NewAccountController and NewAccountView
        newAccountController.setView(newAccountView);
        newAccountView.setController(newAccountController);
    }

    public void generateMap() {
        Map<Integer, Controller> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        map.put(UserOptions.DEPOSIT.getOption(), depositController);
        map.put(UserOptions.WITHDRAW.getOption(), withdrawController);
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);

        mainMenuController.setControllerMap(map);
    }
}
