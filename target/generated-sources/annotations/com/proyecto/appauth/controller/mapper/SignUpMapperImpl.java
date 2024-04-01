package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.auth.SignUpRequestDto;
import com.proyecto.appauth.model.auth.LoginRequest;
import com.proyecto.appauth.model.auth.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T08:45:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SignUpMapperImpl implements SignUpMapper {

    @Override
    public User toSignUpUser(SignUpRequestDto dto) {
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
    public LoginRequest toSignUpLoginRequest(SignUpRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail( dto.getCorreo() );
        loginRequest.setPassword( dto.getContrasenna() );

        return loginRequest;
    }
}
