package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.auth.UserDto;
import com.proyecto.appauth.model.auth.User;
import org.mapstruct.InheritInverseConfiguration;
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
    User toEntity(UserDto dto);

    @InheritInverseConfiguration
    @Mapping(target = "contrasenna", ignore = true)
    UserDto toDto(User entity);
}
