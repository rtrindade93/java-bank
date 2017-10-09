package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.views.View;

import java.util.HashMap;
import java.util.Map;

public class MainMenuController implements Controller {

    private View view;
    private Map<Integer, Controller> controllerMap = new HashMap<>();

    @Override
    public void start() {
        view.show();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    public void setControllerMap(Map<Integer, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    public void setOption(int option){
        if(option <= controllerMap.size()) {
            controllerMap.get(option).start();
            start();
        }
    }
}
