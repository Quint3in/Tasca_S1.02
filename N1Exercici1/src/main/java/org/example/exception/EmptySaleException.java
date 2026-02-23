package org.example.exception;

public class EmptySaleException extends Exception {
    public EmptySaleException(String message) {
        super(message + "| Extends Exception");

    }
}
