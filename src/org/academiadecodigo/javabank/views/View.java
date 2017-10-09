package org.academiadecodigo.javabank.views;

import org.academiadecodigo.javabank.controllers.Controller;

public interface View {
    void show();
    void setController(Controller controller);
}
