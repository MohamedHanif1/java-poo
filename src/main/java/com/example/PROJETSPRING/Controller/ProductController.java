package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.ProductDTO;
import com.example.PROJETSPRING.Mapper.ProductMapper;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiPaths.V1 + ApiPaths.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        Product savedProduct = productService.saveProduct(product);
        ProductDTO savedProductDTO = productMapper.convertToDTO(savedProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<Product> productData = productService.getProductById(id);

        if (productData.isPresent()) {
            ProductDTO productDTO = productMapper.convertToDTO(productData.get());
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = products.stream()
                .map(productMapper::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        product.setId(id); // Ensure the product has the correct ID
        Product updatedProduct = productService.updateProduct(product);

        if (updatedProduct != null) {
            ProductDTO updatedProductDTO = productMapper.convertToDTO(updatedProduct);
            return ResponseEntity.ok(updatedProductDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
