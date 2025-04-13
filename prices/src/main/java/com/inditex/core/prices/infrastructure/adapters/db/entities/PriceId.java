package com.inditex.core.prices.infrastructure.adapters.db.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BRAND_ID")
    private int brandId;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRICE_LIST")
    private int priceList;

} 