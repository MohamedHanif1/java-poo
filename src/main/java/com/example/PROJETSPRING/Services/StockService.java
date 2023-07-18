package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.DTO.ProductDTO;
import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface StockService {
    StockDTO saveStock(StockDTO stockDTO);

    StockDTO getStockById(Long id);

    Page<StockDTO> getAllStocks(Pageable pageable);

    void deleteStock(Long id);
    StockDTO updateStock(Long id, StockDTO stockDTO);

    /*List<StockDTO> getStocksByLocation(String location);

    List<StockDTO> getStocksByProductId(Long productId);

    StockDTO addProductToStock(Long stockId, ProductDTO productDTO, int quantity);

    StockDTO removeProductFromStock(Long stockId, Long productId);


    List<StockDTO> getLowStocks(int threshold);

    List<StockDTO> getStocksWithExpiredProducts();

    List<StockDTO> getStocksByProvider(Long providerId);

    StockDTO updateStockLocation(Long stockId, String newLocation);*/


}
