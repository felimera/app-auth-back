package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.SignUpDto;
import com.proyecto.appauth.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "fullName", source = "nombres")
    @Mapping(target = "email", source = "correo")
    @Mapping(target = "password", source = "contrasenna")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleType", ignore = true)
    User toSignUp(SignUpDto signUpDto);
}
