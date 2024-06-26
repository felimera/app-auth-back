package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.auth.UserDto;
import com.proyecto.appauth.controller.mapper.UserMapper;
import com.proyecto.appauth.exception.ResponseMessageException;
import com.proyecto.appauth.model.auth.User;
import com.proyecto.appauth.model.exception.ExceptionResponseMessage;
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
@RequestMapping(path = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> postUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        log.info("Creating UserDto : {}", userDto);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);

        User user = UserMapper.INSTANCE.toEntity(userDto);
        boolean isUserCreated = userService.createUser(user);
        if (isUserCreated)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ExceptionResponseMessage.builder().code(String.valueOf(HttpStatus.CREATED.value())).message("User created succesfully.").build());
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ExceptionResponseMessage.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message("Failed created user.").build());
    }
}
