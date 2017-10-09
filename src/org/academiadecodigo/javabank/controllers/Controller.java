package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.views.View;

public interface Controller {
    void start();
    void setView(View view);
}
