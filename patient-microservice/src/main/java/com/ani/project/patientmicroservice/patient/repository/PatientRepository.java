package com.ani.project.patientmicroservice.patient.repository;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
