package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.exception.AuthenticationException;
import com.proyecto.appauth.exception.NotFoundException;
import com.proyecto.appauth.model.auth.LoginRequest;
import com.proyecto.appauth.service.LoginService;
import com.proyecto.appauth.service.jwt.UserJwtServiceImpl;
import com.proyecto.appauth.util.Constants;
import com.proyecto.appauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    AuthenticationManager authenticationManager;
    UserJwtServiceImpl userJwtServiceImpl;
    JwtUtil jwtUtil;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, UserJwtServiceImpl userJwtServiceImpl, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userJwtServiceImpl = userJwtServiceImpl;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String getTokenGenerator(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Unauthorized user.", "501", HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails;
        try {
            userDetails = userJwtServiceImpl.loadUserByUsername(loginRequest.getEmail());
        } catch (UsernameNotFoundException e) {
            throw new NotFoundException(Constants.MESSAGE_USER_NOT_FOUND, "501", HttpStatus.NOT_FOUND);
        }

        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
