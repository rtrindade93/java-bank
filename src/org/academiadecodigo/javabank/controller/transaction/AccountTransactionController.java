package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.Controller;

import java.util.Set;

public interface AccountTransactionController extends Controller {

    void submitTransaction(int accountId, double amount);
    int getNumberOfLoginCustomerAccounts();
    Set<Integer> getLoginCustomerAccounts();

}
