package com.inditex.core.prices.infrastructure.mappers;

public interface BidirectionalMapper<D, T> {
    
    D toDomain(T dto);

    T toDTO(D domain);
    
}
