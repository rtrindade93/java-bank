package org.academiadecodigo.javabank;

public class App {

    public static void main(String[] args) {
        Boot boot = new Boot();

        boot.generateData();
        boot.makeConnections();
        boot.generateMap();

        boot.start();
    }
}
