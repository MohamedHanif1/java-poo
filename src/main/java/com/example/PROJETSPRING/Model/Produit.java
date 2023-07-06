package com.example.PROJETSPRING.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String description;
    private BigDecimal prix;
    @ManyToMany(mappedBy = "produits")
    private Set<Commande> commandes = new HashSet<>();
    @ManyToMany(mappedBy = "produits")
    private Set<Fournisseur> fournisseurs = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
