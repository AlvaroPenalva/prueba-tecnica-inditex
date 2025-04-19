package com.inditex.core.prices.infrastructure.mappers;

public interface UnidirectionalMapper<O, D>{

    D map(O origin);    

}
