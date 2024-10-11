package com.almada.manage_people.dto.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PersonUpdateDTO (
        @NotBlank
        @Size(max = 255)
        String name,

        @NotBlank
        @Size(max = 150)
        String email,

        @NotNull
        Integer age,

        @NotBlank
        @Size(max = 255)
        String maritalStatus
) {
}
