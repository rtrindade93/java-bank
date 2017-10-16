package services;

import model.account.Account;

public interface AccountService {

    Account add(Account account);

    void deposit(int id, double amount);

    void withdraw(int id, double amount);

    void transfer(int srcId, int dstId, double amount);

}
