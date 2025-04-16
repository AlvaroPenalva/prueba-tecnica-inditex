package com.inditex.core.prices.infrastructure.adapters.rest.dto;

import java.time.Instant;

public record PriceRestDTO(
    int brandId,
    Instant startDate,
    Instant endDate,
    int priceList,
    long productId,
    int priority,
    float price
) {}