package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Mapper.StockMapper;
import com.example.PROJETSPRING.Services.ProductService;
import com.example.PROJETSPRING.Services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.STOCKS)
public class StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;
    private final ProductService productService;



        @GetMapping("/{id}")
        public ResponseEntity<StockDTO> getStockById(@PathVariable Long id) {
            StockDTO stockDTO = stockService.getStockById(id);
            if (stockDTO != null) {
                return ResponseEntity.ok(stockDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping
        public ResponseEntity<Page<StockDTO>> getAllStocks(Pageable pageable) {
            return ResponseEntity.ok(stockService.getAllStocks(pageable));
        }

    @PostMapping("/stocks")
    public ResponseEntity<StockDTO> saveStock(@RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.saveStock(stockDTO));
    }

        @PutMapping("/{id}")
        public ResponseEntity<StockDTO> updateStock
                (@PathVariable Long id, @Valid @RequestBody StockDTO stockDTO) {
            return ResponseEntity.ok(stockService.updateStock(id,stockDTO));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
            stockService.deleteStock(id);
            return ResponseEntity.noContent().build();
        }
    }


