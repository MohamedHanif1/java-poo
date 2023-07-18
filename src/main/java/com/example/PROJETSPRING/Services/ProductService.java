package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Commands.ProductCommand;
import com.example.PROJETSPRING.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long id);
    Product saveProduct(ProductCommand productCommand);
    Product updateProduct(Long id , ProductCommand productCommand);
    void deleteProduct(Long id);


}
