package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;

public class BalanceController extends AbstractController {

    private CustomerService customerService;

    public Customer gotLoginCustomer() {
        return customerService.getCustomer(authenticationService.getLoginCustomer());
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public double getLoginCustomerBalance() {
        return customerService.getAccountService().getBalance(customerService.getCustomer(authenticationService.getLoginCustomer()).getAccountIds());
    }
}
