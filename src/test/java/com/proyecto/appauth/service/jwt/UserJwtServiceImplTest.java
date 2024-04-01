package com.proyecto.appauth.service.jwt;

import com.proyecto.appauth.model.auth.User;
import com.proyecto.appauth.model.builder.UserBuilder;
import com.proyecto.appauth.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserJwtServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserJwtServiceImpl userJwtServiceImpl;

    @DisplayName("Test JUnit for the LoadUserByUsername method.")
    @Test
    void whenThereIsResultOfTheQuery() {
        User entity1 = UserBuilder.builder().build().toUser();
        given(userRepository.findOneByEmail(anyString())).willReturn(Optional.of(entity1));
        UserDetails userDetails = userJwtServiceImpl.loadUserByUsername(entity1.getEmail());
        assertThat(userDetails).isNotNull();
    }

    @DisplayName("Test JUnit for the LoadUserByUsername method.")
    @Test
    void whenThereIsNotResultOfTheQuery() {
        String email = UserBuilder.builder().build().toUser().getEmail();
        assertThrows(UsernameNotFoundException.class, () -> userJwtServiceImpl.loadUserByUsername(email));
    }
}