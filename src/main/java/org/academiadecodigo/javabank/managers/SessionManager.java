package org.academiadecodigo.javabank.managers;

public interface SessionManager<T> {
    void startSession();
    void stopSession();
    T getCurrentSession();
}
