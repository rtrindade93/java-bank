package org.academiadecodigo.javabank.managers.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaSessionManager {
    private EntityManagerFactory emf; // the persistence unit
    private EntityManager em; // the persistence context

    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
