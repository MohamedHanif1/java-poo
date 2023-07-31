package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.DTO.ProductDTO;
import com.example.PROJETSPRING.DTO.StockDTO;
import com.example.PROJETSPRING.Exception.ErrorFactory;
import com.example.PROJETSPRING.Exception.IdException;
import com.example.PROJETSPRING.Mapper.ProductMapper;
import com.example.PROJETSPRING.Mapper.StockMapper;
import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Model.Stock;
import com.example.PROJETSPRING.Repository.ProductRepository;
import com.example.PROJETSPRING.Repository.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public StockServiceImpl(StockRepository stockRepository, StockMapper stockMapper, ProductMapper productMapper, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public StockDTO saveStock(StockDTO stockDTO) {
        Stock stock = stockMapper.toEntity(stockDTO);
        stock = stockRepository.save(stock);
        return stockMapper.toDTO(stock);
    }

    @Override
    public StockDTO getStockById(Long id) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            return stockMapper.toDTO(stock);
        } else {
            throw new IdException(ErrorFactory.USER_NOT_FOUND.getExceptionPayload());
        }
    }

    @Override
    public StockDTO updateStock(Long id, StockDTO stockDTO) {
        Stock existingStock = stockRepository.findById(id).orElse(null);
        if (existingStock != null) {
            Stock stockToUpdate = stockMapper.toEntity(stockDTO);
            stockToUpdate.setId(id);
            Stock updatedStock = stockRepository.save(stockToUpdate);
            return stockMapper.toDTO(updatedStock);
        }
        return null;
    }

    @Override
    public Page<StockDTO> getAllStocks(Pageable pageable) {
        Page<Stock> stockPage = stockRepository.findAll(pageable);
        return stockPage.map(stockMapper::toDTO);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

   /*

  public StockDTO addProductToStock(Long stockId, ProductDTO productDTO, int quantity) {
        Stock stock = stockRepository.findById(stockId).orElse(null);
        if (stock != null) {
            Product product = productMapper.convertToEntity(productDTO);
            stock.getProducts().put(product, quantity);
            Stock updatedStock = stockRepository.save(stock);
            return stockMapper.toDTO(updatedStock);
        }
        return null;
    }

     public List<StockDTO> getStocksByLocation(String location) {
        List<Stock> stocks = stockRepository.findByLocation(location);
        return stockMapper.toDTOList(stocks);
    }


    public List<StockDTO> getStocksByProductId(Long productId) {
        List<Stock> stocks = stockRepository.findByProductId(productId);
        return stockMapper.toDTOList(stocks);
    }
      public StockDTO removeProductFromStock(Long stockId, Long productId) {
        Stock stock = stockRepository.findById(stockId).orElse(null);
        if (stock != null) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                stock.getProducts().remove(product);
                Stock updatedStock = stockRepository.save(stock);
                return stockMapper.toDTO(updatedStock);
            }
        }
        return null; // Ou vous pouvez lancer une exception ou gérer autrement si nécessaire
    }
    @Override
    public List<StockDTO> getLowStocks(int threshold) {
        List<Stock> lowStocks = stockRepository.findByStockLevelLessThan(threshold);
        return lowStocks.stream()
                .map(stockMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockDTO> getStocksWithExpiredProducts() {
        List<Stock> stocksWithExpiredProducts = stockRepository.findStocksWithExpiredProducts();
        return stocksWithExpiredProducts.stream()
                .map(stockMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockDTO> getStocksByProvider(Long providerId) {
        List<Stock> stocksByProvider = stockRepository.findByProviderId(providerId);
        return stocksByProvider.stream()
                .map(stockMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public StockDTO updateStockLocation(Long stockId, String newLocation) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IdException("Stock not found with ID: " + stockId));
        stock.setLocation(newLocation);
        Stock updatedStock = stockRepository.save(stock);
        return stockMapper.toDTO(updatedStock);
    }*/

}
