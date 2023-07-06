package com.example.PROJETSPRING.Controller;

import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return stockService.getStock(id);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return "Stock removed !! " + id;
    }
}
