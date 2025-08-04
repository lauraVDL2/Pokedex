package com.pokedex.backend.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {
    private String message;
    private String detail;
    private Integer errorCode;
}
