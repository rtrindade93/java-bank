package org.academiadecodigo.javabank.controllers.operations;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.views.View;

public class BalanceController implements Controller {

    private View view;

    @Override
    public void start() {
        view.show();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
