package com.example.PsicologiaSystemBackEnd.Exceptions;

public class EmailOrCpfFoundException extends RuntimeException {
    public EmailOrCpfFoundException(String message) {
        super(message);
    }
}
