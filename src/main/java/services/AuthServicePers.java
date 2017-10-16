package services;

import model.Customer;

import javax.persistence.EntityManagerFactory;

public class AuthServicePers implements AuthService {

    private EntityManagerFactory emf;
    private int accesingCustomer;

    @Override
    public boolean authenticate(Integer id) {
        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return null;
    }
}
