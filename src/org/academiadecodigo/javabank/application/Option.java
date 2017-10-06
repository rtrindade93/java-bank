package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public interface Option {
    void execute(Customer customer);
}
