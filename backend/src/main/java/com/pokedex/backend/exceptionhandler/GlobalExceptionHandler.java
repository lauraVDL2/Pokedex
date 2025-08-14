package com.pokedex.backend.exceptionhandler;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import com.pokedex.backend.exceptionhandler.exceptions.MandatoryDataException;
import com.pokedex.backend.exceptionhandler.exceptions.UnauthorizedException;
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

    @ExceptionHandler(MandatoryDataException.class)
    public ResponseEntity<Error> handleMandatoryDataException(MandatoryDataException ex) {
        Error error = new Error("Mandatory data missing", ex.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Error> handleUnauthorizedException(UnauthorizedException ex) {
        Error error = new Error("Cannot perform this operation", ex.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

}
