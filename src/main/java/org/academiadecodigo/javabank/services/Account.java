package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.dao.CRUD;

public interface Account extends CRUD<org.academiadecodigo.javabank.model.account.Account> {

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

}
