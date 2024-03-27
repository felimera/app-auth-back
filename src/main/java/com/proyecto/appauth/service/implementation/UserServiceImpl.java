package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.exception.BusinessException;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.User;
import com.proyecto.appauth.repository.RoleTypeRepository;
import com.proyecto.appauth.repository.UserRepository;
import com.proyecto.appauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleTypeRepository roleTypeRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleTypeRepository roleTypeRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleTypeRepository = roleTypeRepository;
    }

    @Override
    public boolean createUser(User user) {

        if (this.isEmailExist(user.getEmail())) {
            throw new BusinessException("300", HttpStatus.CONFLICT, "This email already exists.");
        }

        Optional<RoleType> roleTypeOptional = roleTypeRepository.findOneByAcronym("U");
        if (roleTypeOptional.isPresent()) {
            user.setRoleType(roleTypeOptional.get());
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);

            userRepository.save(user);
        }
        return true;
    }

    private boolean isEmailExist(String email) {
        return userRepository.findOneByEmail(email).isPresent();
    }
}
