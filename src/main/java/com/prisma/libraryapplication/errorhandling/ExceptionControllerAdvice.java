package com.prisma.libraryapplication.errorhandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> entityNotFound(Exception ex) {
        log.warn(ex.getMessage());
        return ResponseEntity.notFound().build();
    }
    
    // example is 404 resource not found for unknown endpoints
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> responseStatusError(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
    
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> illegalStateException(IllegalStateException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> internalServerError(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
