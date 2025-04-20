package com.inditex.core.prices.application.dtos;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;

import org.junit.jupiter.api.Test;

import com.inditex.core.prices.application.exceptions.InvalidParamException;

class PriceSearchCriteriaValidationTest {

    private int validBrandId = 1;

    private long validProductId = 35455;

    private Instant validSearchDate = Instant.now();

    @Test
    void testBrandId(){
        assertThrows(InvalidParamException.class, () -> new PriceSearchCriteria(-1, this.validProductId, this.validSearchDate));
    }

    @Test
    void testProductId(){
        assertThrows(InvalidParamException.class, () -> new PriceSearchCriteria(this.validBrandId, -1, this.validSearchDate));
    }

    @Test
    void testSearchDate(){
        assertThrows(InvalidParamException.class, () -> new PriceSearchCriteria(this.validBrandId, this.validProductId, null));
    }

}
