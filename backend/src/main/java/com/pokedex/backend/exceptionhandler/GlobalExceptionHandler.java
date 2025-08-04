package com.pokedex.backend.exceptionhandler;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Error> handleDuplicatedKey(DuplicateKeyException ex) {
        Error error = new Error("Duplicated key", ex.getMessage(), ex.getCode());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<Error> handleMongoWriteException(MongoWriteException ex) {
        Error error = new Error("Cannot create this entity in the db", ex.getError().getMessage(), ex.getError().getCode());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

}
