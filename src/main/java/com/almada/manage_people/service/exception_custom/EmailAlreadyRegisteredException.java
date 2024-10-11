package com.almada.manage_people.service.exception_custom;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super("Email already registered!");
    }

}
