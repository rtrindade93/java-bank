package services;

import model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class AccountServicePers implements AccountService {

    private EntityManagerFactory emf;

    @Override
    public Account add(Account account) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Account newAccount = em.merge(account);
            em.getTransaction().commit(); // close transaction

            return newAccount;
        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deposit(int id, double amount) {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction

            Account account = em.find(Account.class, id);

            if(account == null) {
                return;
            }

            account.credit(amount);

            em.merge(account);
            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void withdraw(int id, double amount) {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction

            Account account = em.find(Account.class, id);

            if(account == null) {
                return;
            }

            account.debit(amount);

            em.merge(account);
            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent
            return;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction

            Account srcAccount = em.find(Account.class, srcId);
            Account dstAccount = em.find(Account.class, dstId);

            // make sure transaction can be performed
            if (!srcAccount.canDebit(amount) || !dstAccount.canCredit(amount)) {
                return;
            }

            srcAccount.debit(amount);
            dstAccount.credit(amount);
            em.merge(srcAccount);
            em.merge(dstAccount);

            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent
            return;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
