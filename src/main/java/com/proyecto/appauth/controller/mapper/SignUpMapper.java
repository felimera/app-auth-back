package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.auth.SignUpRequestDto;
import com.proyecto.appauth.model.auth.User;
import com.proyecto.appauth.model.auth.LoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SignUpMapper {

    SignUpMapper INSTANCE = Mappers.getMapper(SignUpMapper.class);

    @Mapping(target = "fullName", source = "nombres")
    @Mapping(target = "email", source = "correo")
    @Mapping(target = "password", source = "contrasenna")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleType", ignore = true)
    User toSignUpUser(SignUpRequestDto dto);

    @Mapping(target = "email", source = "correo")
    @Mapping(target = "password", source = "contrasenna")
    LoginRequest toSignUpLoginRequest(SignUpRequestDto dto);
}
