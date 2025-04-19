package com.inditex.core.prices.application.ports;

public interface UseCase<P, R>{
    
    R execute(P params);
}
