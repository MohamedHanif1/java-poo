package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Stock;

import java.util.List;

public interface StockService {
    Stock saveStock(Stock stock);
    Stock getStock(Long id);
    List<Stock> getAllStocks();
    void deleteStock(Long id);
}
