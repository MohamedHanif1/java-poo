package com.example.PROJETSPRING.Repository;
import com.example.PROJETSPRING.Model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

}
