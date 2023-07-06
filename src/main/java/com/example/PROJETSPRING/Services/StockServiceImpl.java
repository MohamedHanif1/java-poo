package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
