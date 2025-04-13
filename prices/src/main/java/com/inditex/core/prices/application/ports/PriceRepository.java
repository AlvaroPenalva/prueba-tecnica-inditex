package com.inditex.core.prices.application.ports;

import java.util.List;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.domain.Price;

public interface PriceRepository {

    List<Price> searchPricesByCriteria(PriceSearchCriteria criteria);
    
}
