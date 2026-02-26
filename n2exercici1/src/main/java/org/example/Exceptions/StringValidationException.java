package org.example.Exceptions;

public class StringValidationException extends RuntimeException {
    public StringValidationException(String message) {
        super(message);
    }
}
