package com.example.scootybookingsystem.exceptions.customExceptions;

public class TripAlreadyCompletedException extends RuntimeException{
    public TripAlreadyCompletedException(String message) {
        super(message);
    }
}
