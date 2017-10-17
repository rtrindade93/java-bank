package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.managers.SessionManager;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.JpaGenericDao;

public class JpaAccountDao extends JpaGenericDao<Account> implements AccountDao {

    public JpaAccountDao(SessionManager SessionManager, Class modelType) {
        super(SessionManager, modelType);
    }
}
