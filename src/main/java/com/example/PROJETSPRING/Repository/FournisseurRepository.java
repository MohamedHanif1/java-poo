package com.example.PROJETSPRING.Repository;

import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    Fournisseur findByEmail(String username);
}
