package com.chrisfrederick.marketdata.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.Stock;

import java.time.LocalDateTime;

@Getter
@With
@AllArgsConstructor
public class StockWrapper {
    private final Stock stock;
    private final LocalDateTime lastAccess;

    public  StockWrapper(Stock stock){
        this.stock = stock;
        this.lastAccess = LocalDateTime.now();
    }

    public LocalDateTime getLastAccess(){
        return lastAccess;
    }

    public Stock getStock(){
        return stock;
    }


}
