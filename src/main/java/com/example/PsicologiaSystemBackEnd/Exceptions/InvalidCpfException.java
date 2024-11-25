package com.example.PsicologiaSystemBackEnd.Exceptions;

public class InvalidCpfException extends RuntimeException {
    public InvalidCpfException(String message) {
        super(message);
    }
}
