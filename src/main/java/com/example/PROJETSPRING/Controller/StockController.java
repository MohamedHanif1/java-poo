package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Mapper.StockMapper;
import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Services.ProductService;
import com.example.PROJETSPRING.Services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.STOCKS)
public class StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stockDTO) {
        try {
            Stock stock = stockMapper.toEntity(stockDTO, productService); // pass productService instance here
            Stock savedStock = stockService.saveStock(stock);
            StockDTO savedStockDTO = stockMapper.toDTO(savedStock);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStockDTO);
        } catch (Exception e) {
            // You can log the error here if necessary
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getStock(@PathVariable Long id) {
        Stock stock = stockService.getStock(id);
        if(stock != null) {
            return new ResponseEntity<>(stockMapper.toDTO(stock), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        List<StockDTO> stockDTOs = stocks.stream()
                .map(stockMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(stockDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
