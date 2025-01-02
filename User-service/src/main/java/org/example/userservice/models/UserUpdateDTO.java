package org.example.userservice.models;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Range;

public record UserUpdateDTO(
        String firstname,
        String lastname,
        @Email
        String email,
        @Range(min = 12, max = 120)
        int age,
        String password,
        String address,
        String phone
) {
}
