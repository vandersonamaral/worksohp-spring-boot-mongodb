package com.amaraldev.workshopmongo.resources.exception;

import com.amaraldev.workshopmongo.services.exception.ObjectNotFoundExeception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.mongodb.core.mapping.ExplicitEncrypted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExeception.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExeception e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
