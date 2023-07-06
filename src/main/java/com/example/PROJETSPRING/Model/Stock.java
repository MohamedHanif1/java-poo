package com.example.PROJETSPRING.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Map<Produit, Integer> produits;
    @OneToMany(mappedBy = "stock")
    private Set<Commande> commandes = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private Set<Produit> produit = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private Set<Fournisseur> fournisseur = new HashSet<>();
    private String emplacement;

}
