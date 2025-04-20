package com.inditex.core.prices.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class PriceTest {

   @Test
   void testSearchByPriorityMethod(){
         // Given
         Price price1 = new Price(1, null, null, 1, 35455l, 0, 35.0f, "EUR");
         Price price2 = new Price(2, null, null, 1, 35455l, 1, 25.0f, "EUR");
         Price price3 = new Price(3, null, null, 1, 35455l, 2, 15.0f, "EUR");

         List<Price> prices = List.of(price1, price2, price3);
         // When
         Price result = Price.searchByPriority(prices);
    
         // Then
        assertEquals(price3.getPriority(), result.getPriority());
        assertEquals(price3.getPriceValue(), result.getPriceValue());
        assertEquals(price3.getCurr(), result.getCurr());
        assertEquals(price3.getStartDate(), result.getStartDate());
        assertEquals(price3.getEndDate(), result.getEndDate());
   } 
    
}
