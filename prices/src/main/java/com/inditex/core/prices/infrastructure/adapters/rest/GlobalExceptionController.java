package com.inditex.core.prices.infrastructure.adapters.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.core.prices.domain.exceptions.PriceNotFoundException;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(PriceNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    
}
