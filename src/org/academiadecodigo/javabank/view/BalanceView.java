package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView implements View {

    private BalanceController balanceController;

    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void show() {
        showBalance();
    }

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    private void showBalance() {

        Customer customer = balanceController.gotLoginCustomer();

        System.out.println("\n" + customer.getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(balanceController.getLoginCustomerBalance()));
    }
}
