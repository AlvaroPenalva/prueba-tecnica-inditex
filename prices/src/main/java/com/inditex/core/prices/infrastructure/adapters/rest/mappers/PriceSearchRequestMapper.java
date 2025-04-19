package com.inditex.core.prices.infrastructure.adapters.rest.mappers;

import org.mapstruct.Mapper;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceSearchRequest;
import com.inditex.core.prices.infrastructure.mappers.UnidirectionalMapper;

@Mapper(componentModel = "spring")
public abstract class PriceSearchRequestMapper implements UnidirectionalMapper<PriceSearchRequest, PriceSearchCriteria>{
    
}
