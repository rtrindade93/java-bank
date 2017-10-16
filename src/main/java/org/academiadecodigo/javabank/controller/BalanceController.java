package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.Customer;

public class BalanceController extends AbstractController {

    Customer customerService;

    public org.academiadecodigo.javabank.model.Customer getCustomer() {
        return authService.getAccessingCustomer();
    }

    public double getCustomerBalance() {
        return customerService.getBalance(authService.getAccessingCustomer().getId());
    }

    public void setCustomerService(Customer customerService) {
        this.customerService = customerService;
    }
}
