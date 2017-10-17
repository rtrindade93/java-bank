package org.academiadecodigo.javabank.managers.jpa;

import org.academiadecodigo.javabank.managers.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaSessionManager implements SessionManager<EntityManager> {
    private EntityManagerFactory emf; // the persistence unit
    private EntityManager em; // the persistence context

    @Override
    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
