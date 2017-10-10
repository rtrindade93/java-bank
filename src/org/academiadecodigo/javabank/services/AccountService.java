package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.factories.AccountFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccountService {

    private AccountFactory accountFactory = new AccountFactory();
    private Map<Integer, Account> accountMap;

    public AccountService() {
        accountMap = new HashMap<>();
    }

    public Account findById(int id) {
        return accountMap.get(id);
    }

    public Account openAccount(AccountType accountType) {
        Account newAccount = accountFactory.createAccount(accountType);
        accountMap.put(newAccount.getId(), newAccount);
        return newAccount;
    }

    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accountMap.get(id);
        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        accountMap.get(id).debit(amount);
    }

    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    public double getBalance(int accountId) {
        return accountMap.get(accountId).getBalance();
    }

    public double getBalance(Set<Integer> accounts) {
        double balance = 0;

        for(Integer account: accounts) {
            balance += accountMap.get(account).getBalance();
        }

        return balance;
    }
}
