package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.services.AuthService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
