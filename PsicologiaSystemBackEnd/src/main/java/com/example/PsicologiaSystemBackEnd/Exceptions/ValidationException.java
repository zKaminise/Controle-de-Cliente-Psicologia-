package com.example.PsicologiaSystemBackEnd.Exceptions;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
