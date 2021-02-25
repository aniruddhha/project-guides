package com.ani.project.patientmicroservice;

import com.ani.project.patientmicroservice.http.StandardResponse;
import com.ani.project.patientmicroservice.patient.domain.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Date;
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

	@Test
	public void savePatient() throws JsonProcessingException {
		Patient patient = new Patient(
				1L, "aa", new Date(), "xyz ccv, nn"
		);

		String resObj = restTemplate.postForObject("http://localhost:"+port+"/patient/", patient, String.class);

		ObjectMapper mapper = new ObjectMapper();
		StandardResponse<Patient> res = mapper.readValue(resObj, new TypeReference<StandardResponse<Patient>>() {});
		Assertions.assertNotNull(res.getBody());
		Assertions.assertEquals("aa", res.getBody().getName());
	}
}
