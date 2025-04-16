package com.inditex.core.prices.infrastructure.adapters.db;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.application.ports.PriceRepository;
import com.inditex.core.prices.domain.Price;
import com.inditex.core.prices.infrastructure.adapters.db.dto.PriceSearchCriteriaDTO;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceEntity;
import com.inditex.core.prices.infrastructure.adapters.db.mappers.PriceEntityMapper;
import com.inditex.core.prices.infrastructure.adapters.db.mappers.PriceSearchCriteriaMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PriceRepositoryImpl implements PriceRepository{

    private JpaPriceRepository jpaPriceRepository;

    private PriceEntityMapper priceEntityMapper;

    private PriceSearchCriteriaMapper priceSearchCriteriaMapper;

    @Override
    public List<Price> searchPricesByCriteria(PriceSearchCriteria criteria){

        PriceSearchCriteriaDTO criteriaDTO = priceSearchCriteriaMapper.toDTO(criteria);

        int brandID = criteriaDTO.getBrandId();

        long productId = criteriaDTO.getProductId();

        Instant searchDate = criteriaDTO.getSearchDate();

        List<PriceEntity> entities = jpaPriceRepository.findByBrandIdProductIdAndSearchDate(brandID, productId, searchDate);

        return entities.stream().map(entity -> priceEntityMapper.toDomain(entity)).toList();

    }
    
}