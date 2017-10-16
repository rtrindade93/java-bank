package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.Account;

public class NewAccountController extends AbstractController {

    private Integer newAccountId;
    private AccountFactory accountFactory;
    private Account accountService;

    @Override
    public void init() {
        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        org.academiadecodigo.javabank.model.account.Account newAccount = accountFactory.createAccount(AccountType.CHECKING);
        authService.getAccessingCustomer().addAccount(newAccount);
        org.academiadecodigo.javabank.model.account.Account account = accountService.saveOrUpdate(newAccount);
        return account.getId();
    }

    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setAccountService(Account accountService) {
        this.accountService = accountService;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
}
