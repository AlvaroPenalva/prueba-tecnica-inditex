package com.inditex.core.prices.infrastructure.adapters.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.inditex.core.prices.PricesApplication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;

@SpringBootTest(classes = PricesApplication.class)
@AutoConfigureMockMvc
 class PriceRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testPriceSearchHappyPath(String searchDate, int brandId, long productId, int priceListResult, double priceResult) throws Exception {
        mockMvc.perform(get("/prices/search")
                .param("brandId", String.valueOf(brandId))
                .param("productId", String.valueOf(productId))
                .param("searchDate", searchDate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId").value(brandId))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.priceList").value(priceListResult))
                .andExpect(jsonPath("$.price").value(priceResult));
    }

    @Test
    void testPriceSearchInvalidParams() throws Exception {
        mockMvc.perform(get("/prices/search")
                .param("brandId", String.valueOf(1))
                .param("productId", String.valueOf(-1))
                .param("searchDate", String.valueOf(Instant.now())))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPriceSearchNotFound() throws Exception {
        mockMvc.perform(get("/prices/search")
                .param("brandId", String.valueOf(1))
                .param("productId", String.valueOf(1))
                .param("searchDate", String.valueOf(Instant.now())))
                .andExpect(status().isNotFound());
    }
    
}
