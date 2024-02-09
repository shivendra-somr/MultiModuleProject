package com.agsft.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Error> emloyeeNotFoundException(EmployeeNotFoundException enfe, WebRequest request){
        Error error = new Error(enfe.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> myException(NoHandlerFoundException ex, WebRequest web) {
        Error mec = new Error(ex.getMessage(), web.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(mec, HttpStatus.BAD_REQUEST);
    }
}
