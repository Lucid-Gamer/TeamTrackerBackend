package com.apptrove.TeamTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.sun.jdi.request.InvalidRequestStateException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestStateException.class)
    public ResponseEntity<Object> handleInvalidReqestException(InvalidRequestStateException ex) {
        String message = ex.getMessage();
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
