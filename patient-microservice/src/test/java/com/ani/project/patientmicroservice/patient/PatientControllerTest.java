package com.ani.project.patientmicroservice.patient;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.ani.project.patientmicroservice.patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    public void checkSaved() throws Exception {
        Mockito.when(patientService.savePatient( new Patient(
                1L, "aa", new Date(), "xyz ccv, nn"
        ))).thenReturn(
                new Patient(1L, "aa", new Date(), "xyz ccv, nn")
        );

        mockMvc.perform(
                MockMvcRequestBuilders.post("/patient/")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
