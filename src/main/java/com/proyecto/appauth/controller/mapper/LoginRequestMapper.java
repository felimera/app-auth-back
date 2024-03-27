package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.LoginRequestDto;
import com.proyecto.appauth.model.auth.LoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginRequestMapper {

    LoginRequestMapper INSTANCE = Mappers.getMapper(LoginRequestMapper.class);

    @Mapping(target = "email", source = "correo")
    @Mapping(target = "password", source = "contrasenna")
    LoginRequest toEntity(LoginRequestDto dto);
}
