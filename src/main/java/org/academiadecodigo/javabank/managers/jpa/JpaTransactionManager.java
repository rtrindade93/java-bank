package org.academiadecodigo.javabank.managers.jpa;

import org.academiadecodigo.javabank.managers.SessionManager;
import org.academiadecodigo.javabank.managers.TransactionManager;

import javax.persistence.EntityManager;

public class JpaTransactionManager implements TransactionManager {

    private SessionManager<EntityManager> sm;

    public JpaTransactionManager(SessionManager sm) {
        this.sm = sm;
    }

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    @Override
    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}
