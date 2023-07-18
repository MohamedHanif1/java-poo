package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StockMapper {
    private final ProductService productService;

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

    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setId(stockDTO.getId());
        stock.setLocation(stockDTO.getLocation());

        Map<Product, Integer> productMap = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : stockDTO.getProducts().entrySet()) {
            Product optionalProduct = productService.getProductById(entry.getKey());
            if (optionalProduct != null) {
                Product product = optionalProduct;
                productMap.put(product, entry.getValue());
            }

        }
        stock.setProducts(productMap);
        return stock;
    }
    public List<StockDTO> toDTOList(List<Stock> stocks) {
        return stocks.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


}

