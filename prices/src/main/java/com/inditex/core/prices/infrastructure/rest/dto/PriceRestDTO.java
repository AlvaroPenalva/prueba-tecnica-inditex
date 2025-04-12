package com.inditex.core.prices.infrastructure.rest.dto;

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