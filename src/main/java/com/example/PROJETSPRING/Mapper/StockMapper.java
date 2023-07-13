package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Services.ProductService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StockMapper {

    public StockDTO toDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setLocation(stock.getLocation());

        Map<Long, Integer> productMap = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : stock.getProducts().entrySet()) {
            productMap.put(entry.getKey().getId(), entry.getValue());
        }
        stockDTO.setProducts(productMap);
        return stockDTO;
    }

    public Stock toEntity(StockDTO stockDTO, ProductService productService) {
        Stock stock = new Stock();
        stock.setId(stockDTO.getId());
        stock.setLocation(stockDTO.getLocation());

        Map<Product, Integer> productMap = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : stockDTO.getProducts().entrySet()) {
            Optional<Product> optionalProduct = productService.getProductById(entry.getKey());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                productMap.put(product, entry.getValue());
            }

        }
        stock.setProducts(productMap);
        return stock;
    }
}

