package com.dinger.onlinehousingshow.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> conflict(EntityExistsException e){
        Map<String,Object> found = new HashMap<>();
        found.put("status", HttpStatus.CONFLICT);
        found.put("message",e.getMessage());
        found.put("timeStamp",new Date());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(found);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequest(BadRequestException e){
        Map<String,Object> badRequest = new HashMap<>();
        badRequest.put("status",HttpStatus.BAD_REQUEST);
        badRequest.put("message",e.getMessage());
        badRequest.put("timeStamp",new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequest);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> notFound(EntityNotFoundException e){
        Map<String,Object> notFound = new HashMap<>();
        notFound.put("status",HttpStatus.NOT_FOUND);
        notFound.put("message",e.getMessage());
        notFound.put("timeStamp",new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
    }

}
