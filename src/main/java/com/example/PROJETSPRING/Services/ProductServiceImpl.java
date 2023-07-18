package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Commands.ProductCommand;
import com.example.PROJETSPRING.Exception.IdException;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Page<Product> getAllProducts(Pageable pageable) {

        return productRepository.findAll(pageable);
    }



    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
    @Override
    public Product saveProduct(ProductCommand productCommand) {
            Product product = Product.create(productCommand);
        return productRepository.save(product);
    }



    public Product updateProduct(Long id , ProductCommand productCommand){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IdException("Product not found with customerId: " + id));
        product.update(productCommand);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }





}
