package com.example.PROJETSPRING.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String adresse;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "client")
    private Set<Commande> commandes = new HashSet<>();

}

