package com.ani.project.patientmicroservice.patient;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.ani.project.patientmicroservice.patient.repository.PatientRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository repository;

    @Test
    @Order(1)
    @Rollback(false)
    public void savePatient() {
        Patient patient = new Patient(
                1L,"Android", new Date(), "xyz, pqr bhh"
        );
        assertNotNull(repository.save(patient));
    }

    @Test
    @Order(2)
    public void listAllPatients() {
        List<Patient> patients = repository.findAll();
        assertThat(patients).size().isGreaterThan(0);
    }
}
