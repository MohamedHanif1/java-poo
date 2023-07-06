package com.example.PROJETSPRING.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PROJETSPRING.Model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
