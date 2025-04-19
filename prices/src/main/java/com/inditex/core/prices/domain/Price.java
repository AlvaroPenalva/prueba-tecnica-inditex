package com.inditex.core.prices.domain;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

import com.inditex.core.prices.domain.exceptions.PriceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {

    private int brandId;

    private Instant startDate;

    private Instant endDate;

    private int priceList;

    private long productId;

    private int priority;

    private float price;

    private String curr;
    
    public static Price searchByPriority(List<Price> prices){
        return prices.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> PriceNotFoundException.create("No price found"));
    }
}