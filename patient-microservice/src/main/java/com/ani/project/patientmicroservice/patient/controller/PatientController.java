package com.ani.project.patientmicroservice.patient.controller;

import com.ani.project.patientmicroservice.http.StandardResponse;
import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.ani.project.patientmicroservice.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/")
    public StandardResponse<Patient> savePatient(@RequestBody  Patient patient) {
        return new StandardResponse<>(patientService.savePatient(patient), "operation successful", "success") ;
    }

    @GetMapping("/")
    public List<Patient> listPatients() {
        return patientService.patients();
    }
}
