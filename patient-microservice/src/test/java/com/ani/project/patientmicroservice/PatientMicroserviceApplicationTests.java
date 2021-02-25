package com.ani.project.patientmicroservice;

import com.ani.project.patientmicroservice.patient.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientMicroserviceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testFindAllCustomers() {
		List<Patient> patients =  restTemplate.getForObject("http://localhost:"+port+"/patient/", List.class);
		Assertions.assertNotNull(patients);
		Assertions.assertEquals(1, patients.size());
	}
}
