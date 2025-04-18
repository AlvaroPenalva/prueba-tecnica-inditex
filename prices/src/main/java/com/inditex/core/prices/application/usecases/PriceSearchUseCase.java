package com.inditex.core.prices.application.usecases;

import org.springframework.stereotype.Service;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.application.ports.PriceRepository;
import com.inditex.core.prices.application.ports.UseCase;
import com.inditex.core.prices.domain.Price;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceSearchUseCase implements UseCase<PriceSearchCriteria, Price>{

    private final PriceRepository priceRepository;

    public Price execute(PriceSearchCriteria params){
        var prices = priceRepository.searchPricesByCriteria(params);
        return Price.searchByPriority(prices);
    }
    
}