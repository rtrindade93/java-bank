package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.persistence.dao.GenericDao;
import org.academiadecodigo.javabank.services.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class JpaAccount extends GenericDao<org.academiadecodigo.javabank.model.account.Account> implements Account {

    public JpaAccount(EntityManagerFactory emf) {
        super(emf, org.academiadecodigo.javabank.model.account.Account.class);
    }

    @Override
    public void deposit(Integer id, double amount) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            org.academiadecodigo.javabank.model.account.Account account = em.find(org.academiadecodigo.javabank.model.account.Account.class, id);

            if (account == null) {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            account.credit(amount);
            em.merge(account);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void withdraw(Integer id, double amount) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            org.academiadecodigo.javabank.model.account.Account account = em.find(org.academiadecodigo.javabank.model.account.Account.class, id);

            if (account == null) {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);
            em.merge(account);

            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            org.academiadecodigo.javabank.model.account.Account srcAccount = em.find(org.academiadecodigo.javabank.model.account.Account.class, srcId);
            org.academiadecodigo.javabank.model.account.Account dstAccount = em.find(org.academiadecodigo.javabank.model.account.Account.class, dstId);

            if (srcAccount == null || dstAccount == null) {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

            em.merge(srcAccount);
            em.merge(dstAccount);

            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {

            if (em != null) {
                em.close();
            }
        }
    }
}
