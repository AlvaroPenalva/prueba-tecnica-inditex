package com.inditex.core.prices.infrastructure.adapters.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.core.prices.domain.Price;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceEntity;
import com.inditex.core.prices.infrastructure.mappers.UnidirectionalMapper;

@Mapper(componentModel = "spring")
public abstract class PriceEntityMapper implements UnidirectionalMapper<PriceEntity, Price>{

    @Mapping(target = "brandId", source = "priceId.brandId")
    @Mapping(target = "productId", source = "priceId.productId")
    @Mapping(target = "priceList", source = "priceId.priceList")
    @Override
    public abstract Price map(PriceEntity priceEntity);
}