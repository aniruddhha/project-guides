package com.ani.project.patientmicroservice.patient;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.ani.project.patientmicroservice.patient.repository.PatientRepository;
import com.ani.project.patientmicroservice.patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository repository;

    @InjectMocks
    private PatientService service;

    @Test
    public void savePatient() {

        Patient patient = new Patient(
                1L,
                "Android",
                new Date(),
                "xyz, pqr bhh"
        );

        when(
                repository.save(any(Patient.class))
        ).then(
                AdditionalAnswers.returnsFirstArg()
        );

        Patient mk = service.savePatient(patient);

        assertNotNull(mk);
    }
}
