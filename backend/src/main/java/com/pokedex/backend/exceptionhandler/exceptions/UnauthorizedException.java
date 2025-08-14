package com.pokedex.backend.exceptionhandler.exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}
