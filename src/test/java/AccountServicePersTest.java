import model.account.Account;
import model.account.CheckingAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.AccountServicePers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.TestCase.*;

public class AccountServicePersTest {

    private EntityManagerFactory emf;
    private AccountServicePers accountServicePers;

    @Before
    public void setup() {

        emf = Persistence.createEntityManagerFactory("test");

        accountServicePers = new AccountServicePers();
        accountServicePers.setEntityManagerFactory(emf);
    }

    @After
    public void end() {
        emf.close();
    }

    @Test
    public void addTest() {

        Account account = accountServicePers.add(new CheckingAccount());

        EntityManager em = emf.createEntityManager();
        Account savedAccount = em.find(Account.class, account.getId());

        assertEquals(account.getId(), savedAccount.getId());
        em.close();
    }

    @Test
    public void depositTest() {

        Account account = accountServicePers.add(new CheckingAccount());

        accountServicePers.deposit(account.getId(), 200);

        EntityManager em = emf.createEntityManager();
        Account savedAccount = em.find(Account.class, account.getId());

        assertEquals(200.0, savedAccount.getBalance());
        em.close();
    }

    @Test
    public void withdrawTest() {
        Account account = accountServicePers.add(new CheckingAccount());

        accountServicePers.deposit(account.getId(), 200);
        accountServicePers.withdraw(account.getId(), 100);

        EntityManager em = emf.createEntityManager();
        Account savedAccount = em.find(Account.class, account.getId());

        assertEquals(100.0, savedAccount.getBalance());
        em.close();
    }

    @Test
    public void transferTest() {
        Account srcAccount = accountServicePers.add(new CheckingAccount());
        Account dstAccount = accountServicePers.add(new CheckingAccount());

        accountServicePers.deposit(srcAccount.getId(), 200);

        accountServicePers.transfer(srcAccount.getId(), dstAccount.getId(), 100);

        EntityManager em = emf.createEntityManager();
        Account savedSrcAccount = em.find(Account.class, srcAccount.getId());
        Account savedDstAccount = em.find(Account.class, dstAccount.getId());

        assertEquals(100.0, savedSrcAccount.getBalance());
        assertEquals(100.0, savedDstAccount.getBalance());
        em.close();
    }
}
