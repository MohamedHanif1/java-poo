package com.example.PROJETSPRING.Controller;

import com.example.PROJETSPRING.Commands.ProductCommand;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.ProductDTO;
import com.example.PROJETSPRING.Mapper.ProductMapper;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(ApiPaths.V1 + ApiPaths.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;



    @GetMapping
    public ResponseEntity <Page<ProductDTO>> getAllProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.getAllProducts(pageable).map(productMapper ::convertToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product != null) {
            ProductDTO productDTO = productMapper.convertToDTO(product);
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductCommand productCommand) {
        return ResponseEntity.ok(productMapper.convertToDTO(productService.saveProduct(productCommand)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct
            (@PathVariable Long id, @Valid @RequestBody ProductCommand productCommand) {
        return ResponseEntity.ok(productMapper.convertToDTO(productService.updateProduct( id ,productCommand)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();


    }

}
