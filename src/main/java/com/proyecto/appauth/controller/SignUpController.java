package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.LoginResponseDto;
import com.proyecto.appauth.controller.dto.SignUpRequestDto;
import com.proyecto.appauth.controller.dto.SignUpResponseDto;
import com.proyecto.appauth.controller.dto.UserDto;
import com.proyecto.appauth.controller.mapper.SignUpMapper;
import com.proyecto.appauth.controller.mapper.UserMapper;
import com.proyecto.appauth.exception.ResponseMessageException;
import com.proyecto.appauth.model.User;
import com.proyecto.appauth.model.auth.LoginRequest;
import com.proyecto.appauth.model.exception.ExceptionResponseMessage;
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
@RequestMapping(path = "/signup")
@CrossOrigin(origins = "http://localhost:4200")
public class SignUpController {

    private UserService userService;
    private LoginService loginService;

    @Autowired
    public SignUpController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> postSign(@Valid @RequestBody SignUpRequestDto dto, BindingResult bindingResult) {
        log.info("Creating SignUpRequestDto : {}", dto);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);

        User user = SignUpMapper.INSTANCE.toSignUpUser(dto);
        boolean isUserCreated = userService.createUser(user);

        if (isUserCreated) {

            LoginRequest loginRequest = SignUpMapper.INSTANCE.toSignUpLoginRequest(dto);
            String jwt = loginService.getTokenGenerator(loginRequest);

            UserDto userDto = UserMapper.INSTANCE.toDto(user);

            SignUpResponseDto signUpResponseDto = new SignUpResponseDto(userDto, new LoginResponseDto(jwt));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(signUpResponseDto);
        } else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ExceptionResponseMessage.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message("Failed created user.").build());
    }
}
