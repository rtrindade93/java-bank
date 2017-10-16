import controller.LoginController;
import persistence.H2WebServer;
import services.AccountServiceImpl;
import services.AuthServiceImpl;
import services.CustomerServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {
            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

            App app = new App();
            app.bootStrap();

            emf.close();
            h2WebServer.stop();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl());
        bootstrap.setCustomerService(new CustomerServiceImpl());
        bootstrap.loadCustomers();

        LoginController loginController = bootstrap.wireObjects();

        // start application
        loginController.init();

    }
}
