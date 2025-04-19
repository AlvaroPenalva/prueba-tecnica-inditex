package com.inditex.core.prices.infrastructure.adapters.db.mappers;

import org.mapstruct.Mapper;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.infrastructure.adapters.db.dto.PriceSearchCriteriaDTO;
import com.inditex.core.prices.infrastructure.mappers.UnidirectionalMapper;

@Mapper(componentModel = "spring")
public abstract class PriceSearchCriteriaMapper implements UnidirectionalMapper<PriceSearchCriteria, PriceSearchCriteriaDTO>{
    
}
