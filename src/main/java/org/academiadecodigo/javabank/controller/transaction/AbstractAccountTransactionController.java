package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.services.Account;
import org.academiadecodigo.javabank.services.Customer;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    Account accountService;
    Customer customerService;

    public Set<Integer> getAccountIds() {
        return customerService.getCustomerAccountIds(authService.getAccessingCustomer().getId());
    }

    public void setAccountService(Account accountService) {
        this.accountService = accountService;
    }

    public void setCustomerService(Customer customerService) {
        this.customerService = customerService;
    }
}
