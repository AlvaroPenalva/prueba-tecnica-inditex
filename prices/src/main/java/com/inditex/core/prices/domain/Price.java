package com.inditex.core.prices.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {

    private String brandId;

    private Instant startDate;

    private Instant endDate;

    private int priceList;

    private long productId;

    private int priority;

    private float price;
    
}