package com.example.PROJETSPRING.Repository;

import com.example.PROJETSPRING.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByName(String name);
    //Provider findByEmail(String username);
}
