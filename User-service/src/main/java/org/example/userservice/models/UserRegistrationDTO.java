package org.example.userservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDTO(
        @NotBlank String firstname,
        @NotBlank String lastname,
        @Email String email )
{
    // TODO: Add other important fields during user registration
}
