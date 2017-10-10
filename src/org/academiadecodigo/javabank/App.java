package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;

public class App {

    private CustomerService customerService;
    private AuthenticationService authenticationService;

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        customerService = bootstrap.generateTestData();
        authenticationService = new AuthenticationService();
        authenticationService.setCustomerService(customerService);

        LoginController loginController = bootstrap.wireObjects(customerService, authenticationService);

        // start application
        loginController.init();

    }

}
