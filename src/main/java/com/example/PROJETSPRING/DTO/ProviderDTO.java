package com.example.PROJETSPRING.DTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProviderDTO {
    private Long id;
    private String name;
    private String adress;
    private String mail;
    private String phoneNumber;
    private Set<Long> productIds; // IDs des produits associés
    private Long stockId; // ID du stock associé
}