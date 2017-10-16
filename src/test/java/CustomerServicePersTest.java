import model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.CustomerServicePers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import static junit.framework.TestCase.*;

public class CustomerServicePersTest {

    private EntityManagerFactory emf;
    private CustomerServicePers customerServicePers;

    @Before
    public void setup() {

        emf = Persistence.createEntityManagerFactory("test");

        customerServicePers = new CustomerServicePers();
        customerServicePers.setEntityManagerFactory(emf);
    }

    @After
    public void end() {
        emf.close();
    }

    @Test
    public void addTest() {

        Customer customer = customerServicePers.add(new Customer());

        EntityManager em = emf.createEntityManager();
        Customer savedCustomer = em.find(Customer.class, customer.getId());

        assertEquals(customer.getId(), savedCustomer.getId());
        em.close();
    }

    @Test
    public void findByIdTest() {
        Customer customer = customerServicePers.add(new Customer());
        Customer findedCustomer = customerServicePers.findById(customer.getId());

        assertEquals(customer.getId(), findedCustomer.getId());
    }
}
