package org.example.exceptions;

public class StringValidationException extends RuntimeException {
    public StringValidationException(String message) {
        super(message);
    }
}
