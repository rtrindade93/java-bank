package controller;

import factories.AccountFactory;
import model.Customer;
import model.account.Account;
import model.account.AccountType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.AccountService;
import services.AuthService;
import view.View;

public class NewAccountControllerTest {
    private NewAccountController newAccountController;
    private View view;
    private AccountFactory accountFactory;
    private AccountService accountService;
    private AuthService authService;

    @Before
    public void setup() {
        newAccountController = new NewAccountController();
        view = Mockito.mock(View.class);
        accountFactory = Mockito.mock(AccountFactory.class);
        accountService = Mockito.mock(AccountService.class);
        authService = Mockito.mock(AuthService.class);

        newAccountController.setAccountFactory(accountFactory);
        newAccountController.setAccountService(accountService);
        newAccountController.setView(view);
        newAccountController.setAuthService(authService);
    }

    @Test
    public void initTest() {
        Account account = Mockito.mock(Account.class);
        Customer customer = Mockito.mock(Customer.class);
        Mockito.when(accountFactory.createAccount(AccountType.CHECKING)).thenReturn(account);
        Mockito.when(authService.getAccessingCustomer()).thenReturn(customer);

        newAccountController.init();

        Mockito.verify(view).show();
    }
}
