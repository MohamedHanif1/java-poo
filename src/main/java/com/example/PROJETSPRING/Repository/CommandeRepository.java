package com.example.PROJETSPRING.Repository;
import com.example.PROJETSPRING.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
