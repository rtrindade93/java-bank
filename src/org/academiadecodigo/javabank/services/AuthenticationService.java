package org.academiadecodigo.javabank.services;

public class AuthenticationService {

    private CustomerService customerService;
    private int loginCustomer;

    public boolean authenticateCustomer(int id) {
        if(customerService.getCustomerIds().contains(id)) {
            loginCustomer = id;
            return true;
        }
        return false;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public int getLoginCustomer() {
        return loginCustomer;
    }
}
