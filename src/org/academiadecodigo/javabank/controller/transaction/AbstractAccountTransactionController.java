package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected CustomerService customerService;

    @Override
    public int getNumberOfLoginCustomerAccounts(){
        return customerService.getCustomer(authenticationService.getLoginCustomer()).getAccountIds().size();
    }

    @Override
    public Set<Integer> getLoginCustomerAccounts() {
        return customerService.getCustomer(authenticationService.getLoginCustomer()).getAccountIds();
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
