package com.proyecto.appauth.controller;

import com.proyecto.appauth.controller.dto.SignUpDto;
import com.proyecto.appauth.controller.mapper.UserMapper;
import com.proyecto.appauth.model.User;
import com.proyecto.appauth.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/signup")
@CrossOrigin(origins = "http://localhost:4200")
public class SignupController {

    private UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> signUser(@Valid @RequestBody SignUpDto signUpDto, BindingResult bindingResult) {

        User user = UserMapper.INSTANCE.toSignUp(signUpDto);
        boolean isUserCreated = userService.createUser(user);
        return ResponseEntity.ok().build();
//        if (isUserCreated)
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(ExceptionResponseMessage.builder().code(String.valueOf(HttpStatus.CREATED.value())).message("User created succesfully.").build());
//        else
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(ExceptionResponseMessage.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message("Failed created user.").build());
    }
}
