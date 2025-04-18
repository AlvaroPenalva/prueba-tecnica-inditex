package com.inditex.core.prices.application.ports;

public interface UseCase<P extends Param<R>, R>{
    
    R execute(P params);
}
