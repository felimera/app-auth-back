package com.proyecto.appauth.service;

import com.proyecto.appauth.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean createUser(User user);

    boolean isExistUser(String email);
}
