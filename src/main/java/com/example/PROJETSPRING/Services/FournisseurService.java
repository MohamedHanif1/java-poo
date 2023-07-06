package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.Model.Fournisseur;
import java.util.List;

public interface FournisseurService {
    List<Fournisseur> getAllFournisseurs();
    Fournisseur getFournisseurById(Long id);
    Fournisseur createFournisseur(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    void deleteFournisseur(Long id);
}
