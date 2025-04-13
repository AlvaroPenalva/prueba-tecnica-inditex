package com.inditex.core.prices.infrastructure.adapters.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.application.ports.PriceRepository;
import com.inditex.core.prices.domain.Price;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PriceRepositoryImpl implements PriceRepository{

    private JpaPriceRepository jpaPriceRepository;

    //TODO
    @Override
    public List<Price> searchPricesByCriteria(PriceSearchCriteria criteria){

        return List.of();

    }
    
}