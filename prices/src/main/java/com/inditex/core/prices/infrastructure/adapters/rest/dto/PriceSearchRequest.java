package com.inditex.core.prices.infrastructure.adapters.rest.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceSearchRequest {

    private int brandId;

    private long productId;

    private ZonedDateTime searchDate;
    
}
