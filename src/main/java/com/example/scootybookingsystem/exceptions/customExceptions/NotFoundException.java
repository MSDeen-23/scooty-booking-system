package com.example.scootybookingsystem.exceptions.customExceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String value) {super(value+ " not found");}
}
