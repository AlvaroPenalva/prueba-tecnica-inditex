package com.inditex.core.prices.infrastructure.adapters.db;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceEntity;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceId;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, PriceId>{

     @Query("select p from PriceEntity p where p.priceId.brandId = ?1 AND p.priceId.productId = ?2 AND p.startDate <= ?3 AND p.endDate >= ?3")
    public List<PriceEntity> findByBrandIdProductIdAndSearchDate(int brandId, long productId, ZonedDateTime searchDate);
    
}
