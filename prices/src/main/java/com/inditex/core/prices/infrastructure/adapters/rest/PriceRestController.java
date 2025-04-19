package com.inditex.core.prices.infrastructure.adapters.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.core.prices.application.usecases.PriceSearchUseCase;
import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceRestDTO;
import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceSearchRequest;
import com.inditex.core.prices.infrastructure.adapters.rest.mappers.PriceRestMapper;
import com.inditex.core.prices.infrastructure.adapters.rest.mappers.PriceSearchRequestMapper;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("prices")
@AllArgsConstructor
public class PriceRestController {

    private PriceSearchRequestMapper priceSearchRequestMapper;

    private PriceSearchUseCase searchPriceUseCase;

    private PriceRestMapper priceRestMapper;

    @GetMapping("/search")
    public PriceRestDTO search(PriceSearchRequest request){
        
        var params = priceSearchRequestMapper.map(request);
        //call usecase
        var result = searchPriceUseCase.execute(params);
        return  priceRestMapper.map(result);
    }
    
}
