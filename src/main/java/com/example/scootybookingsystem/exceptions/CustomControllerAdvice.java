package com.example.scootybookingsystem.exceptions;

import com.example.scootybookingsystem.exceptions.customExceptions.NoNearByOutletsFoundException;
import com.example.scootybookingsystem.exceptions.customExceptions.NotFoundException;
import com.example.scootybookingsystem.exceptions.customExceptions.SaveOutletFailedException;
import com.example.scootybookingsystem.exceptions.customExceptions.TripAlreadyCompletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
    }

    @ExceptionHandler(SaveOutletFailedException.class)
    public ResponseEntity<ErrorResponse> handleSaveOutletFailedException(SaveOutletFailedException e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
    }

    @ExceptionHandler(NoNearByOutletsFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoNearByOutletsFoundException(NoNearByOutletsFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
    }

    @ExceptionHandler(TripAlreadyCompletedException.class)
    public ResponseEntity<ErrorResponse> handleTripAlreadyCompletedException(TripAlreadyCompletedException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
    }


}
