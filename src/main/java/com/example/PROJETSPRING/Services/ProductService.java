package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();

    Product updateProduct(Product product);
}
