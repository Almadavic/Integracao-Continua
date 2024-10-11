package com.almada.manage_people.config.exception;

import com.almada.manage_people.service.exception_custom.InvalidTypeException;
import com.almada.manage_people.service.exception_custom.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception) {
        return handle(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidTypeException.class)
    public ResponseEntity<StandardError> invalidType(InvalidTypeException exception) {
        return handle(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<StandardError> handle(Exception exception, HttpStatus status) {
        return ResponseEntity.status(status).body(new StandardError(exception.getMessage(), status.value()));
    }


}
