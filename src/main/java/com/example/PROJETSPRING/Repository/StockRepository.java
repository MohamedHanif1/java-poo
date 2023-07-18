package com.example.PROJETSPRING.Repository;

import com.example.PROJETSPRING.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByLocation(String location);

    List<Stock> findByProductId(Long productId);

    List<Stock> findByProviderId(Long providerId);
    List<Stock> findByStockLevelLessThan(int threshold);
    @Query("SELECT s FROM Stock s WHERE s.expirationDate < CURRENT_DATE")
    List<Stock> findStocksWithExpiredProducts();
}
