package com.inditex.core.prices.infrastructure.adapters.db.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@AllArgsConstructor
@Getter
public class PriceId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BRAND_ID")
    private String brandId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

} 