package com.almada.manage_people.config.exception;

public record StandardError (
        String message,
        Integer status
) {
}
