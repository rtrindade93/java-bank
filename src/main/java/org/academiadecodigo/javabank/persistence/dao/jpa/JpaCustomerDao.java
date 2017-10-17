package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.JpaGenericDao;
import org.academiadecodigo.javabank.managers.SessionManager;

public class JpaCustomerDao extends JpaGenericDao implements CustomerDao {

    public JpaCustomerDao(SessionManager sessionManager, Class modelType) {
        super(sessionManager, modelType);
    }
}
