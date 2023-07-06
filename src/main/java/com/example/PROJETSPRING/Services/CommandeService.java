package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> getCommandes();
    Optional<Commande> getCommandeById(Long id);
    Commande addCommande(Commande commande);
    Commande updateCommande(Commande commande);
    void deleteCommande(Long id);
}
