package com.realstatemanager.exceptions;

public class BadRequestException extends ResponseException {
    public BadRequestException() {
        super("Request was not properly built", 400);
    }
}
