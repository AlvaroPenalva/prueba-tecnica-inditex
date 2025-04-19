package com.inditex.core.prices.infrastructure.adapters.db.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceSearchCriteriaDTO {

    private int brandId;

    private long productId;

    private ZonedDateTime searchDate;
    
}
