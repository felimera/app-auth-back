package com.proyecto.appauth.controller.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotEmpty(message = "The customer's email cannot be empty.")
    @NotNull(message = "The email cannot be null.")
    @Email(message = "The email is not formatted correctly.")
    @Size(max = 100, message = "The customer's email only has a maximum of 100 characters.")
    private String correo;
    @NotEmpty(message = "The client password cannot be empty.")
    @NotNull(message = "The client password cannot be null.")
    @Size(max = 100, min = 6, message = "The client password has a minimum of 6 characters and a maximum of 100 characters.")
    private String contrasenna;
}
