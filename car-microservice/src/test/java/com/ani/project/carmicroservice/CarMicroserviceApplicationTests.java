package com.ani.project.carmicroservice;

import com.ani.project.carmicroservice.billing.domain.Bill;
import com.ani.project.carmicroservice.billing.domain.Supplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarMicroserviceApplicationTests {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("POST - check bill is generating or not")
	@Order(1)
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

	@Test
	@Order(2)
	@Rollback(false)
	public void saveContractData() {
		String res = restTemplate.getForObject("http://localhost:"+port+"/supplier/save", String.class);
		Assertions.assertEquals("saved", res);
	}

	@Test
	@Order(3)
	public void getAllSuppliers() throws JsonProcessingException {
		String res = restTemplate.getForObject("http://localhost:"+port+"/supplier/save", String.class);
		ObjectMapper mapper = new ObjectMapper();
		Set<Supplier> suppliers = mapper.readValue(res, new TypeReference<Set<Supplier>>() {});
		assertThat( suppliers.size(), Matchers.greaterThan(0));
	}
}
