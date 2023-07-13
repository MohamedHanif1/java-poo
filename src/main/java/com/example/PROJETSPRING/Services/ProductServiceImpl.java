package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(Long id) {

        return productRepository.findById(id);
    }
    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);}

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}
