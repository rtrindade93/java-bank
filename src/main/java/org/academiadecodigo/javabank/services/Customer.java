package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.dao.CRUD;

import java.util.Set;

public interface Customer extends CRUD<org.academiadecodigo.javabank.model.Customer> {

    double getBalance(Integer id);

    Set<Integer> getCustomerAccountIds(Integer id);

}
