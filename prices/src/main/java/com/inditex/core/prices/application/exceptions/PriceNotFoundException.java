package com.inditex.core.prices.application.exceptions;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;

public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(String messagge){
        super(messagge);
    }

    public static PriceNotFoundException create(String message){
        return new PriceNotFoundException(message);
    }

    public static PriceNotFoundException createFromCriteria(PriceSearchCriteria criteria){
        return new PriceNotFoundException("Price not found for brandId: " + criteria.getBrandId() +
                ", productId: " + criteria.getProductId() +
                ", searchDate: " + criteria.getSearchDate());
    }
    
}
