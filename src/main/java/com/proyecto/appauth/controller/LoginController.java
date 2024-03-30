package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.auth.LoginRequestDto;
import com.proyecto.appauth.controller.dto.auth.LoginResponseDto;
import com.proyecto.appauth.controller.mapper.LoginRequestMapper;
import com.proyecto.appauth.exception.ResponseMessageException;
import com.proyecto.appauth.model.auth.LoginRequest;
import com.proyecto.appauth.service.LoginService;
import com.proyecto.appauth.service.UserService;
import com.proyecto.appauth.util.CadenaUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    private UserService userService;

    private LoginService loginService;

    @Autowired
    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        log.info("Creating LoginRequestDto : {}", loginRequestDto);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);

        LoginRequest loginRequest = LoginRequestMapper.INSTANCE.toEntity(loginRequestDto);
        userService.isExistUser(loginRequest.getEmail());

        String jwt = loginService.getTokenGenerator(loginRequest);
        // Aditional logic can here be added here if needed.
        return ResponseEntity.ok(new LoginResponseDto(jwt));
    }
}
