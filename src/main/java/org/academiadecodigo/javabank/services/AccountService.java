package org.academiadecodigo.javabank.services;

public interface AccountService {

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

}
