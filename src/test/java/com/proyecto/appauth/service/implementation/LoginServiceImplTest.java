package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.exception.NotFoundException;
import com.proyecto.appauth.model.auth.LoginRequest;
import com.proyecto.appauth.model.builder.LoginRequestBuilder;
import com.proyecto.appauth.repository.UserRepository;
import com.proyecto.appauth.service.jwt.UserJwtServiceImpl;
import com.proyecto.appauth.util.JwtUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserJwtServiceImpl userJwtServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Mock
    private JwtUtil jwtUtil;
    @InjectMocks
    private LoginServiceImpl loginServiceImpl;

    @DisplayName("Test JUnit for the GetTokenGenerator method.")
    @Test
    void whenTheTokenReturnsTheResult() {
        LoginRequest request = LoginRequestBuilder.builder().build().toLoginRequest();
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(request.getEmail(), request.getPassword(), Collections.emptyList());
        ;
        given(userJwtServiceImpl.loadUserByUsername(anyString())).willReturn(userDetails);
        given(jwtUtil.generateToken(anyString())).willReturn(anyString());

        String token = loginServiceImpl.getTokenGenerator(request);

        assertThat(token).isNotNull();
    }

    @DisplayName("Test JUnit for the GetTokenGenerator method.")
    @Test
    void whenTheUserDoesNotExist() {
        LoginRequest request = LoginRequestBuilder.builder().build().toEditEmailAndPass(null, null);
        assertThrows(NotFoundException.class, () -> loginServiceImpl.getTokenGenerator(request));
    }
}