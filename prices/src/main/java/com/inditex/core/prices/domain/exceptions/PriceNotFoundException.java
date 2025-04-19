package com.inditex.core.prices.domain.exceptions;

public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(String messagge){
        super(messagge);
    }

    public static PriceNotFoundException create(String message){
        return new PriceNotFoundException(message);
    }
    
}
