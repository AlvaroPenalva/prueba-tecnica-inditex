package com.inditex.core.prices.infrastructure.adapters.rest.mappers;

import org.mapstruct.Mapper;

import com.inditex.core.prices.domain.Price;
import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceRestDTO;
import com.inditex.core.prices.infrastructure.mappers.UnidirectionalMapper;

@Mapper(componentModel = "spring")
public abstract class PriceRestMapper implements UnidirectionalMapper<Price, PriceRestDTO>{

}