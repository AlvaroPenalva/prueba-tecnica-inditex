package com.inditex.core.prices.infrastructure.adapters.db.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceSearchCriteriaDTO {

    private int brandId;

    private long productId;

    private Instant searchDate;
    
}
