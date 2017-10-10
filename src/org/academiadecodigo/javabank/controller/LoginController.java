package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.view.InterfaceLoginView;

public class LoginController extends AbstractController {

    private Controller nextController;

    public void onLogin(int id) {
        if(authenticationService.authenticateCustomer(id)){
            nextController.init();
        }
        else {
            ((InterfaceLoginView) view).showError(); //TODO: please do not cast (now casting from interface but...)
            init();
        }
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }
}
