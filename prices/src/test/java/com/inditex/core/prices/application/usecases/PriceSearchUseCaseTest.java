package com.inditex.core.prices.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inditex.core.prices.application.dtos.PriceSearchCriteria;
import com.inditex.core.prices.application.exceptions.PriceNotFoundException;
import com.inditex.core.prices.application.ports.PriceRepository;
import com.inditex.core.prices.domain.Price;

@ExtendWith(MockitoExtension.class)
class PriceSearchUseCaseTest {

    @InjectMocks
    private PriceSearchUseCase priceSearchUseCase;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void givenExistingPrice_WhenSearchInRepository_ThenFindPrice(){

        // Given
        List<Price> prices = List.of(new Price(1, Instant.now(), Instant.now(), 1, 35455l, 0, 35.0f, "EUR"));

        PriceSearchCriteria criteria = new PriceSearchCriteria(1, 35455l, Instant.now());

        when(priceRepository.searchPricesByCriteria(criteria)).thenReturn(prices);
        
        //When
        var result = priceSearchUseCase.execute(criteria);

        //Then
        assertNotNull(result);
        assertEquals(prices.getFirst(), result);
        verify(priceRepository, atLeastOnce()).searchPricesByCriteria(any());

    }

    @Test
    void givenNonExistingPrice_WhenSearchInRepository_ThenThrowsException(){

        //Given
        PriceSearchCriteria criteria = new PriceSearchCriteria(1, 35455l, Instant.now());

        when(priceRepository.searchPricesByCriteria(criteria)).thenReturn(List.of());

        //Then

        assertThrows(PriceNotFoundException.class, () -> priceSearchUseCase.execute(criteria));
        
    }
    
}
