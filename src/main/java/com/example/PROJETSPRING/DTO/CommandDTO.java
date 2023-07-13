package com.example.PROJETSPRING.DTO;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Getter
@Setter

public class CommandDTO {
    private Long id;
    private Set<Long> productIds = new HashSet<>();
    private Long clientId;
    private Long stockId;
    private Map<Long, Integer> productIdToQuantity;
    private String status;
}
