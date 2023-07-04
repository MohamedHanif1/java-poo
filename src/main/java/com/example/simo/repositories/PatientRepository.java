package com.example.simo.repositories;

import com.example.simo.entities.Patient;
import com.example.simo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
