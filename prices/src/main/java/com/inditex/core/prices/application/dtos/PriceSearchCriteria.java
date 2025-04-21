package com.inditex.core.prices.application.dtos;

import java.time.Instant;

import com.inditex.core.prices.application.exceptions.InvalidParamException;
import lombok.Getter;

@Getter
public class PriceSearchCriteria{

    private int brandId;

    private long productId;

    private Instant searchDate;

    public PriceSearchCriteria(int brandId, long productId, Instant searchDate) {
        setBrandId(brandId);
        setProductId(productId);
        setSearchDate(searchDate);
    }

    private void setBrandId(int brandId) {
        if(brandId <= 0){
            throw InvalidParamException.create("BrandId must be a positive integer");
        }
        this.brandId = brandId;
    }

    private void setProductId(long productId) {
        if(productId <= 0){
            throw InvalidParamException.create("ProductId must be a positive integer");
        }
        this.productId = productId;
    }

    private void setSearchDate(Instant searchDate) {
        if(searchDate == null){
            throw InvalidParamException.create("SearchDate must not be null");
        }
        this.searchDate = searchDate;
    }
    
}
