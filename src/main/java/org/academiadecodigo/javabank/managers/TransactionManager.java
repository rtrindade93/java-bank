package org.academiadecodigo.javabank.managers;

public interface TransactionManager {

    void beginRead();
    void beginWrite();
    void commit();
    void rollback();
}
