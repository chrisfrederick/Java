package com.chrisfrederick.marketdata.controllers;

import com.chrisfrederick.marketdata.services.StockService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@EnableAutoConfiguration
public class StockController {
    @GetMapping("/")
    BigDecimal home(){
        StockService stockService = new StockService();
        return stockService.findStock("GOOG").getStock().getQuote().getPrice();
    }

}
