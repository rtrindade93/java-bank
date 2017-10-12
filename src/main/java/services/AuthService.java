package services;

import model.Customer;

public interface AuthService {

    boolean authenticate(Integer id);

    Customer getAccessingCustomer();

}
