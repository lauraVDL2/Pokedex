package com.pokedex.backend.exceptionhandler.exceptions;

public class MandatoryDataException extends IllegalArgumentException {

    public MandatoryDataException(String message) {
        super(message);
    }
}
