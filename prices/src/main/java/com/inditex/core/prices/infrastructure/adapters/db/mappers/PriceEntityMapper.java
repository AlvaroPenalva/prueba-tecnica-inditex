package com.inditex.core.prices.infrastructure.adapters.db.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.core.prices.domain.Price;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceEntity;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceId;
import com.inditex.core.prices.infrastructure.mappers.GenericMapper;

@Mapper(componentModel = "spring")
public abstract class PriceEntityMapper implements GenericMapper<Price, PriceEntity>{

    public PriceEntity toDTO(Price price){
        PriceId priceId = toPriceId(price);
        return  new PriceEntity(priceId, price.getStartDate(), price.getEndDate(), price.getPriority(), price.getPrice(), price.getCurr());
    }

    @Mapping(target = "brandId", source = "priceId.brandId")
    @Mapping(target = "productId", source = "priceId.productId")
    @Mapping(target = "priceList", source = "priceId.priceList")
    @Override
    public abstract Price toDomain(PriceEntity priceEntity);

    protected PriceId toPriceId(Price price){
        return new PriceId(price.getBrandId(), price.getProductId(), price.getPriceList());
    }
}