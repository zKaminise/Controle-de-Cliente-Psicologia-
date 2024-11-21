package com.example.PsicologiaSystemBackEnd.Exceptions;

public class EmailOrCpfFoundException extends RuntimeException {
    public EmailOrCpfFoundException() {
        super("Email ou CPF já existe");
    }
}
