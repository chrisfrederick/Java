package com.chrisfrederick.marketdataapp.services;

import com.chrisfrederick.marketdataapp.models.StockWrapper;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

@Service
public class StockService {
    public StockWrapper findStock(String symbol) {
        try {
            return new StockWrapper(YahooFinance.get(symbol));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
