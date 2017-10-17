package org.academiadecodigo.javabank.services;

public class AuthServiceImpl implements AuthService {

    private Integer accessingCustomerId;
    private CustomerService customerService;

    @Override
    public boolean authenticate(Integer id) {

        org.academiadecodigo.javabank.model.Customer customer = customerService.findById(id);

        if (customer == null) {
            return false;
        }

        accessingCustomerId = customer.getId();
        return true;
    }

    @Override
    public org.academiadecodigo.javabank.model.Customer getAccessingCustomer() {
        return customerService.findById(accessingCustomerId);
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
