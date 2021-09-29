package com.raulmelo.finansysapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardException> objectNotFoudException(ObjectNotFoundException e){
        
        StandardException error = new StandardException();
        
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(e.getMessage());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
}
