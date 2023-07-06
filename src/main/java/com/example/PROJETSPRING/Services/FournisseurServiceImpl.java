package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.Model.Fournisseur;
import com.example.PROJETSPRING.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return fournisseur.orElse(null);
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
