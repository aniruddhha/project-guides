package com.ani.project.patientmicroservice.patient.service;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.ani.project.patientmicroservice.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> patients() {
        return repository.findAll();
    }
}
