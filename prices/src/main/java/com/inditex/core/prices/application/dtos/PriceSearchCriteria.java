package com.inditex.core.prices.application.dtos;

import java.time.Instant;

import com.inditex.core.prices.application.ports.Param;
import com.inditex.core.prices.domain.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceSearchCriteria implements Param<Price>{

    private int brandId;

    private long productId;

    private Instant searchDate;
    
}
