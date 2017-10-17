package org.academiadecodigo.javabank.exceptions;

public class TransactionException extends RuntimeException {
    // Parameterless Constructor
    public TransactionException() {

    }

    // Constructor that accepts a message
    public TransactionException(String message)
    {
        super(message);
    }
}
