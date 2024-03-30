package com.proyecto.appauth.controller.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponseDto {
    private UserDto userDto;
    private LoginResponseDto loginResponseDto;
}
