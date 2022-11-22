package com.boogie.rest.exeption_handling;

public class BadDataIncomingException extends RuntimeException{
    public BadDataIncomingException(String message) {
        super(message);
    }
}
