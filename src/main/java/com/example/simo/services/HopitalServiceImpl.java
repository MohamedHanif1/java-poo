package com.example.simo.services;

import com.example.simo.entities.Patient;
import com.example.simo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HopitalServiceImpl implements HopitalService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public void deleteAllPatients() {
        patientRepository.deleteAll();

    }

    @Override
    public Page<Patient> getAlllPatientsByPage(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page,size));
    }
}
