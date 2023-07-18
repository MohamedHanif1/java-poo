package com.example.PROJETSPRING.Commands;

import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Product;
import com.example.PROJETSPRING.Model.Stock;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Getter
@Setter
@RequiredArgsConstructor
public class CommandCommand {


    @NotEmpty(message = "At least one product must be provided.")
    private Set<Product> products = new HashSet<>();

    @NotNull(message = "Client cannot be null.")
    private Client client;


    @NotNull(message = "Stock cannot be null.")
    private Stock stock;

    @ElementCollection
    @NotEmpty(message = "Product map cannot be empty.")
    private Map<Product, Integer> produit;

    @NotNull(message = "Status cannot be null.")
    @Pattern(regexp = "^(PENDING|SHIPPED|DELIVERED)$", message = "Invalid status.")
    private String status;
}
