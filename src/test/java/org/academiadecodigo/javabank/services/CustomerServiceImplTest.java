package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    private static final double DOUBLE_PRECISION = 0.1;

    private TransactionManager tx;
    private CustomerDao customerDao;
    private CustomerServiceImpl customerService;

    @Before
    public void setup() {

        tx = mock(TransactionManager.class);
        customerDao = mock(CustomerDao.class);

        customerService = new CustomerServiceImpl();
        customerService.setTransactionManager(tx);
        customerService.setCustomerDao(customerDao);

    }

    @Test
    public void testFindById() {

        // setup
        int fakeId = 9999;
        Customer fakeCustomer = new Customer();
        when(customerDao.findById(fakeId)).thenReturn(fakeCustomer);

        // exercise
        Customer customer = customerService.findById(fakeId);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();
        assertEquals(fakeCustomer, customer);
    }

    @Test(expected = TransactionException.class)
    public void testFindByIdFail() {

        // setup
        doThrow(new TransactionException(new RuntimeException())).when(customerDao).findById(anyInt());

        // exercise
        customerService.findById(1);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();

    }

    @Test
    public void testGetBalance() {

        // setup
        int fakeId = 9999;
        Account a1 = new CheckingAccount();
        Account a2 = new CheckingAccount();
        a1.credit(100);
        a2.credit(200);
        Customer fakeCustomer = new Customer();
        fakeCustomer.getAccounts().add(0, a1);
        fakeCustomer.getAccounts().add(1, a2);
        when(customerDao.findById(fakeId)).thenReturn(fakeCustomer);

        // exercise
        double result = customerService.getBalance(fakeId);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();
        assertEquals(a1.getBalance() + a2.getBalance(), result, DOUBLE_PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBalanceInvalidCustomer() {

        // setup
        when(customerDao.findById(anyInt())).thenReturn(null);

        // exercise
        customerService.getBalance(1);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();
    }

    @Test(expected = TransactionException.class)
    public void testGetBalanceFail() {

        // setup
        doThrow(new TransactionException(new RuntimeException())).when(customerDao).findById(anyInt());

        // exercise
        customerService.getBalance(1);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();

    }

    @Test
    public void testGetCustomerAccountIds() {

        // setup
        int fakeId = 9999;
        Account a1 = new CheckingAccount();
        Account a2 = new CheckingAccount();
        a1.credit(100);
        a1.setId(1);
        a2.credit(200);
        a2.setId(2);
        Customer fakeCustomer = new Customer();
        fakeCustomer.getAccounts().add(a1);
        fakeCustomer.getAccounts().add(a2);
        when(customerDao.findById(fakeId)).thenReturn(fakeCustomer);

        // exercise
        Set<Integer> accountIds = customerService.getCustomerAccountIds(fakeId);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();
        assertNotNull(accountIds);
        assertEquals(fakeCustomer.getAccounts().size(), accountIds.size());
        assertTrue(accountIds.contains(a1.getId()));
        assertTrue(accountIds.contains(a2.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCustomerAccountIdsInvalidId() {

        // setup
        when(customerDao.findById(anyInt())).thenReturn(null);

        // exercise
        customerService.getCustomerAccountIds(1);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();

    }

    @Test(expected = TransactionException.class)
    public void testGetCustomerAccountIdsFail() {

        // setup
        doThrow(new TransactionException(new RuntimeException())).when(customerDao).findById(anyInt());

        // exercise
        customerService.getCustomerAccountIds(1);

        // verify
        verify(tx, times(1)).beginRead();
        verify(tx, times(1)).commit();

    }

}
