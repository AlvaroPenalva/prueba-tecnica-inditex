package com.inditex.core.prices.infrastructure.adapters.rest;

import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.core.prices.application.exceptions.InvalidParamException;
import com.inditex.core.prices.application.exceptions.PriceNotFoundException;

@ControllerAdvice
public class GlobalExceptionController {

    private ResponseEntity<HashMap<String, String>> buildResponseEntity(String message, HttpStatus status) {
        HashMap<String, String> response = new HashMap<>();
        response.put("error: ", message);
        response.put("status: ", String.valueOf(status.value()));
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleNotFoundException(PriceNotFoundException exception){
        return buildResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<HashMap<String, String>> handleInvalidParamException(InvalidParamException exception){
        return buildResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, String>> handleGeneralException(Exception exception){
        return buildResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleHttpMessageNotReadable(MethodArgumentNotValidException ex) {
        return buildResponseEntity("Invalid param in request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<HashMap<String, String>> handleDatabaseTimeout(Exception ex) {
        return buildResponseEntity("Database timeout", HttpStatus.GATEWAY_TIMEOUT);
    }

}
