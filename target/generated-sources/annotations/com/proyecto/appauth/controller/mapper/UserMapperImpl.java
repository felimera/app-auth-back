package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.auth.UserDto;
import com.proyecto.appauth.model.auth.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T08:45:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( dto.getNombres() );
        user.setEmail( dto.getCorreo() );
        user.setPassword( dto.getContrasenna() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setNombres( entity.getFullName() );
        userDto.setCorreo( entity.getEmail() );

        return userDto;
    }
}
