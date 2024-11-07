package com.projetoAccenture.exception;

public class EmailExisteException extends RuntimeException {
    public EmailExisteException(String message) {
        super(message);
    }
}