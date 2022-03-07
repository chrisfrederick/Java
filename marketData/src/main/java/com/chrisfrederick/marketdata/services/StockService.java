package com.chrisfrederick.marketdata.services;

import com.chrisfrederick.marketdata.models.StockWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;


@Service
public class StockService {
    public StockWrapper findStock(String symbol){
        try{
            return new StockWrapper(YahooFinance.get(symbol));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
