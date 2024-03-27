package com.proyecto.appauth.service;

import com.proyecto.appauth.model.auth.LoginRequest;

public interface LoginService {
    String getTokenGenerator(LoginRequest loginRequest);
}
