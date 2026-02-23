package org.example.exception;

public class EmptySaleException extends RuntimeException {
    public EmptySaleException(String message) {
        super(message + " | Extends RuntimeException");

    }
}
