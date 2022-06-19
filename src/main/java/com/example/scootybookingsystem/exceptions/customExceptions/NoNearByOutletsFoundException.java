package com.example.scootybookingsystem.exceptions.customExceptions;

public class NoNearByOutletsFoundException extends RuntimeException{
    public NoNearByOutletsFoundException(String message) {
        super(message);
    }
}
