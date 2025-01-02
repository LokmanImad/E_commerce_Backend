package org.example.userservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record UserUpdateDTO(
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @Email
        String email,
        @Range(min = 12, max = 120)
        int age,
        @NotBlank
        String password,
        String address,
        String phone
) {
}
