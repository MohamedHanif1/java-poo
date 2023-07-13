package com.example.PROJETSPRING.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PROJETSPRING.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
