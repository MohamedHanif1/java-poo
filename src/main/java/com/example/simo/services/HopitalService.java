package com.example.simo.services;

import com.example.simo.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HopitalService {
    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    void deletePatientById(Long id);
    void deleteAllPatients();
    Page<Patient> getAlllPatientsByPage(int page,int size);
}
