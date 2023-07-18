package com.example.PROJETSPRING.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
@Getter
@Setter
public class StockDTO {
    private Long id;
    private Map<Long, Integer> products;
    private LocalDate expirationDate;
    private int stockLevel;
    private String location;
}
