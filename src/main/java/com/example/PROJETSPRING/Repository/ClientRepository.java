package com.example.PROJETSPRING.Repository;

import com.example.PROJETSPRING.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
    Optional<Client> findById(Long id);
}
