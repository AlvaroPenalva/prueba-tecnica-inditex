package com.inditex.core.prices.infrastructure.adapters.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceRestDTO;
import com.inditex.core.prices.infrastructure.adapters.rest.dto.PriceSearchRequest;
import com.inditex.core.prices.infrastructure.adapters.rest.mappers.PriceSearchRequestMapper;
import com.inditex.core.prices.infrastructure.adapters.rest.mappers.PriceSearchRequestMapperImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("prices")
@AllArgsConstructor
public class PriceRestController {

    private PriceSearchRequestMapper priceSearchRequestMapper;

    @GetMapping("search")
    public PriceRestDTO search(PriceSearchRequest request){
        
        //TODO
        //call usecase
        priceSearchRequestMapper.toDomain(request);
        return null;
    }
    
}
