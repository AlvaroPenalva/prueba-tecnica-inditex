package com.inditex.core.prices.infrastructure.db.dto;

import java.time.Instant;
import java.util.Currency;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "prices")
public class PriceEntity {

    private String brandId;

    private Instant startDate;

    private Instant endDate;

    private int priceList;

    private long productId;

    private int priority;

    private float price;

    private Currency currency;
    
}
