package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.view.View;

public abstract class AbstractController implements Controller {

    protected View view;
    protected AuthenticationService authenticationService;

    public void setView(View view) {
        this.view = view;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void init() {
        view.show();
    }
}
