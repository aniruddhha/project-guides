package com.ani.project.carmicroservice;

import com.ani.project.carmicroservice.billing.domain.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarMicroserviceApplicationTests {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("POST - check bill is generating or not")
	public void generateBill() {

		Bill bill = new Bill(
				1L,
				new Date(),
				"Android"
		);

		Bill resObj = restTemplate.postForObject("http://localhost:"+port+"/bill/", bill, Bill.class);
		Assertions.assertNotNull(resObj);
		Assertions.assertEquals("Android", resObj.getCustomerName());
	}
}
