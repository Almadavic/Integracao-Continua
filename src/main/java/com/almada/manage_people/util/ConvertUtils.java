package com.almada.manage_people.util;

import com.almada.manage_people.enumerated.MaritalStatus;
import com.almada.manage_people.service.exception_custom.InvalidTypeException;

public class ConvertUtils {

    private ConvertUtils() {

    }

    public static MaritalStatus convertMaritalStatus(String maritalStatus) {
        try {
            return MaritalStatus.valueOf(maritalStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidTypeException("The type: " + maritalStatus + " is not a valid marital status");
        }
    }

}
