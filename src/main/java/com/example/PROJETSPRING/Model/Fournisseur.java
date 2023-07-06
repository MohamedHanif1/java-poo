package com.example.PROJETSPRING.Model;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "produits")
@ToString(exclude = "produits")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String adresse;

    private String email;

    private String telephone;
    @ManyToMany
    @JoinTable(
            name = "fournisseur_produit",
            joinColumns = @JoinColumn(name = "fournisseur_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Produit> produits = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
