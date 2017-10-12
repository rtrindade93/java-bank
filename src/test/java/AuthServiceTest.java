import model.Customer;
import services.AuthServiceImpl;
import services.CustomerService;
import services.CustomerServiceImpl;

public class AuthServiceTest {

    public boolean test() {

        AuthServiceImpl authService = new AuthServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        authService.setCustomerService(customerService);

        Customer customer = new Customer();
        customerService.add(customer);

        // should authenticate
        authService.authenticate(customer.getId());
        if (authService.getAccessingCustomer() != customer) {
            return false;
        }

        return true;
    }
}
