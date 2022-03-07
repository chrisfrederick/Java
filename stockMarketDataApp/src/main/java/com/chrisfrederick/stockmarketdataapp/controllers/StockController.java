package com.chrisfrederick.stockmarketdataapp.controllers;

import com.chrisfrederick.stockmarketdataapp.models.StockModel;
import com.chrisfrederick.stockmarketdataapp.models.StockResponseModel;
import com.chrisfrederick.stockmarketdataapp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class StockController {
    @Autowired
    private StockService stockService;


    @RequestMapping(value="/", produces= MediaType.APPLICATION_JSON_VALUE)
    StockModel home() {
        Stock stock = stockService.findStock("GOOG").getStock();
        StockModel stockModel = new StockModel("GOOG", stock.getName(), stock.getQuote().getAsk().toString(), stock.getQuote().getChangeInPercent().toString());

        return stockModel;
    }



    @CrossOrigin(origins = "*")
    @GetMapping(value="/getstock", produces= MediaType.APPLICATION_JSON_VALUE)
    StockResponseModel getStocks() {
        List<StockModel> stocks = new ArrayList<>();
        String[] symbolArr = {"A", "AA", "AAC", "GOOG", "AMZN", "AAT", "AAN", "T", "TD", "TARO", "TM"};

        for (String s : symbolArr) {
            Stock stock = stockService.findStock(s).getStock();
            StockModel stockModel = new StockModel(s, stock.getName(), stock.getQuote().getAsk().toString(), stock.getQuote().getChangeInPercent().toString());
            stocks.add(stockModel);
        }

        StockResponseModel res = new StockResponseModel();
        res.setStock(stocks);
        res.setStockExg("US");

        return res;
    }


}
