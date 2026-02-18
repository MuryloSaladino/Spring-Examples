package com.realstatemanager.exceptions;

public class NotFoundException extends ResponseException {
    public NotFoundException() {
        super("The requested entity was not found", 404);
    }
}
