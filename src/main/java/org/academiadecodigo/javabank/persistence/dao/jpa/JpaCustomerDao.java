package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.managers.SessionManager;

public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao {

    public JpaCustomerDao(SessionManager sessionManager) {
        super(sessionManager, Customer.class);
    }
}
