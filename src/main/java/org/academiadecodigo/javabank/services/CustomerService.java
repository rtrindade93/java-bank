package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.dao.DAO;

import java.util.Set;

public interface CustomerService extends DAO<org.academiadecodigo.javabank.model.Customer> {

    double getBalance(Integer id);

    Set<Integer> getCustomerAccountIds(Integer id);

}
