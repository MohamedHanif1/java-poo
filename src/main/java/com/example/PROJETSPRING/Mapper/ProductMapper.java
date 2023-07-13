package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.ProductDTO;
import com.example.PROJETSPRING.Model.Command;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Model.Provider;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStockId(product.getStock().getId());
        productDTO.setCommandIds(product.getCommands()
                .stream()
                .map(Command::getId)
                .collect(Collectors.toSet()));
        productDTO.setProviderIds(product.getProviders()
                .stream()
                .map(Provider::getId)
                .collect(Collectors.toSet()));
        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        // For relationships like Commands and Providers, you might need to fetch the actual entity objects
        // based on the IDs in the DTO and set them in the product entity here.
        // Also for Stock, if you just have the ID, you will need to fetch the actual Stock entity.
        return product;
    }

}