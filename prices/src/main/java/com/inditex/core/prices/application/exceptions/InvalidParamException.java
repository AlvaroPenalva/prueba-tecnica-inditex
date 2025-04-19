package com.inditex.core.prices.application.exceptions;

public class InvalidParamException extends RuntimeException{
    public InvalidParamException(String message) {
        super(message);
    }

    public static InvalidParamException create(String message) {
        return new InvalidParamException(message);
    }
}
