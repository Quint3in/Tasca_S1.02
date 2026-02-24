package org.example.Exceptions;

public class SeatPositionOutOfRangeException extends RuntimeException {
    public SeatPositionOutOfRangeException(String message) {
        super(message);
    }
}
