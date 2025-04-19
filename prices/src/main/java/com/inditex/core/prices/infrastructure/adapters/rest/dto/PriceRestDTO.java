package com.inditex.core.prices.infrastructure.adapters.rest.dto;

import java.time.ZonedDateTime;

public record PriceRestDTO(
    int brandId,
    ZonedDateTime startDate,
    ZonedDateTime endDate,
    int priceList,
    long productId,
    int priority,
    float price
) {}