package com.inditex.core.prices.infrastructure.adapters.db;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceEntity;
import com.inditex.core.prices.infrastructure.adapters.db.entities.PriceId;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, PriceId>{

    @Query("SELECT p FROM PriceEntity p WHERE p.priceId.brandId = :brandId AND p.priceId.productId = :productId AND :searchDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    public List<PriceEntity> findByBrandIdProductIdAndSearchDate(@Param("brandId")int brandId, @Param("productId") long productId, @Param("searchDate") Instant searchDate);
    
}
