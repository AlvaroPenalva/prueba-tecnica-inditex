package com.inditex.core.prices.domain;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {

    private int brandId;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private int priceList;

    private long productId;

    private int priority;

    private float priceValue;

    private String curr;
    
    public static Price searchByPriority(List<Price> prices){
        return prices.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElse(null);
    }
}