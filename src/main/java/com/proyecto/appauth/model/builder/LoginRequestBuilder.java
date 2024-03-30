package com.proyecto.appauth.model.builder;

import com.proyecto.appauth.model.auth.LoginRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestBuilder {
    private String email;
    private String password;

    private LoginRequestBuilder toLoginRequestBuilder() {
        return LoginRequestBuilder.builder()
                .email("user@user.com")
                .password("password")
                .build();
    }

    public LoginRequest toLoginRequest() {
        LoginRequestBuilder builder = toLoginRequestBuilder();
        return new LoginRequest(
                builder.email,
                builder.password
        );
    }

    public LoginRequest toEditEmailAndPass(String email, String password) {
        return new LoginRequest(
                email,
                password
        );
    }
}
