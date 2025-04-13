package com.inditex.core.prices.application.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceSearchCriteria {

    private int brandId;

    private long productId;

    private Instant searchDate;
    
}
