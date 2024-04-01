package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.auth.LoginRequestDto;
import com.proyecto.appauth.model.auth.LoginRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T07:50:30-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class LoginRequestMapperImpl implements LoginRequestMapper {

    @Override
    public LoginRequest toEntity(LoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail( dto.getCorreo() );
        loginRequest.setPassword( dto.getContrasenna() );

        return loginRequest;
    }
}
