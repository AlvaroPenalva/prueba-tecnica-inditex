package com.inditex.core.prices.infrastructure.adapters.db.entities;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceEntity {

    @EmbeddedId
    private PriceId priceId;

    @Column(name = "START_DATE")
    private ZonedDateTime startDate;

    @Column(name = "END_DATE")
    private ZonedDateTime endDate;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private float priceValue;

    @Column(name = "CURR")
    private String curr;
    
}