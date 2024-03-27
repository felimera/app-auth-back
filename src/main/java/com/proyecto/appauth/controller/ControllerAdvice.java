package com.proyecto.appauth.controller;

import com.proyecto.appauth.exception.BadRequest;
import com.proyecto.appauth.exception.NotFoundException;
import com.proyecto.appauth.exception.ResponseMessageException;
import com.proyecto.appauth.model.exception.ExceptionControlMessage;
import com.proyecto.appauth.model.exception.ExceptionResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponseMessage> runtimeExceptionHandler(RuntimeException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponseMessage> notFoundExceptionHandler(NotFoundException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<ExceptionResponseMessage> notBadRequestHandler(BadRequest ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResponseMessageException.class)
    public ResponseEntity<ExceptionControlMessage> responseStatusExceptionHandler(ResponseMessageException ex) {
        ExceptionControlMessage error = ExceptionControlMessage.builder().code(ex.getCode()).message(ex.getMessage()).keyValueExceptionsMessages(ex.getKeyValueExceptionsMessages()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

}
