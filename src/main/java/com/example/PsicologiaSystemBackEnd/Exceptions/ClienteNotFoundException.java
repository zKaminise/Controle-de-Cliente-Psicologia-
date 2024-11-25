package com.example.PsicologiaSystemBackEnd.Exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String message) {
        super(message);
    }
}
