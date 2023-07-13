package com.example.PROJETSPRING.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Set<Long> commandIds = new HashSet<>(); // IDs of associated Commands
    private Set<Long> providerIds = new HashSet<>(); // IDs of associated Providers
    private Long stockId; // ID of associated Stock
}
