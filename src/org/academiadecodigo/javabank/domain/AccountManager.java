package org.academiadecodigo.javabank.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private Map<Integer, Account> accountMap = new HashMap();

    public int createAccount(AccountType accountType) {
        Account account;
        if(accountType == AccountType.CHECKING){
            account = new CheckingAccount(accountMap.size() + 1);
            return account.getId();
        }
        else if(accountType == AccountType.SAVINGS){
            account = new SavingsAccount(accountMap.size() + 1);
            return account.getId();
        }
        return 0;
    }

    public double getBalance(int id){
        return accountMap.get(id).getBalance();
    }

    public void deposit(int id, double amount){
        accountMap.get(id).credit(amount);
    }

    public void withdraw(int id, double amount){
        Account account = accountMap.get(id);

        if(account.getAccountType() == AccountType.SAVINGS){
            return;
        }
    }
}
