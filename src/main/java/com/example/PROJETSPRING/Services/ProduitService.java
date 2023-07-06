package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    Produit saveProduit(Produit produit);
    void deleteProduit(Long id);
    Optional<Produit> getProduitById(Long id);
    List<Produit> getAllProduits();
}
