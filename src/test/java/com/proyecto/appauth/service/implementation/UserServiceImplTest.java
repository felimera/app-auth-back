package com.proyecto.appauth.service.implementation;

import com.proyecto.appauth.exception.BusinessException;
import com.proyecto.appauth.exception.NotFoundException;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.auth.User;
import com.proyecto.appauth.model.builder.RoleTypeBuilder;
import com.proyecto.appauth.model.builder.UserBuilder;
import com.proyecto.appauth.repository.RoleTypeRepository;
import com.proyecto.appauth.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private RoleTypeRepository roleTypeRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @DisplayName("Test JUnit for the CreateUser method.")
    @Test
    void whenTheUserIsCreatedSuccessfully() {
        User entity1 = UserBuilder.builder().build().toUser();
        RoleType type = RoleTypeBuilder.builder().build().toRoleType();
        given(roleTypeRepository.findOneByAcronym(anyString())).willReturn(Optional.of(type));
        given(passwordEncoder.encode(anyString())).willReturn("asdasdawrfasfasfrweqrq");
        given(userRepository.save(any(User.class))).willReturn(entity1);
        boolean resultado = userServiceImpl.createUser(entity1);
        assertTrue(resultado);
    }

    @DisplayName("Test JUnit for the CreateUser method.")
    @Test
    void whenTheEmailAlreadyExists() {
        User entity1 = UserBuilder.builder().build().toUser();
        User entity2 = UserBuilder.builder().build().toEditEmail("test@test.com");
        given(userRepository.findOneByEmail(anyString())).willReturn(Optional.of(entity2));
        assertThrows(BusinessException.class, () -> userServiceImpl.createUser(entity1));
    }

    @DisplayName("Test JUnit for the IsExistUser method.")
    @Test
    void whenTheUsersEmailNotExist() {
        User entity1 = UserBuilder.builder().build().toUser();
        given(userRepository.findOneByEmail(anyString())).willReturn(Optional.of(entity1));
        boolean resultado = userServiceImpl.isExistUser(entity1.getEmail());
        assertTrue(resultado);
    }

    @DisplayName("Test JUnit for the IsExistUser method.")
    @Test
    void whenTheUsersEmailExists() {
        String email = UserBuilder.builder().build().toUser().getEmail();
        given(userRepository.findOneByEmail(anyString())).willReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> userServiceImpl.isExistUser(email));
    }
}