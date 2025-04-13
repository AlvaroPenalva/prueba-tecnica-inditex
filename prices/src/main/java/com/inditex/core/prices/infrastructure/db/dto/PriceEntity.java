package com.inditex.core.prices.infrastructure.db.dto;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "PRICES")
public class PriceEntity {

    @EmbeddedId
    private PriceId priceId;

    @Column(name = "START_DATE")
    private Instant startDate;

    @Column(name = "END_DATE")
    private Instant endDate;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "CURR")
    private String curr;
    
}