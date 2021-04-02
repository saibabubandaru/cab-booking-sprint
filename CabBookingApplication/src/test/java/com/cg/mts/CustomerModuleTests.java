package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Driver;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CustomerModuleTests extends AbstractTest {

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getStausCode() throws Exception {
		String uri = "/customer/6";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void getUsername() throws Exception {
		String uri = "/customer/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer customer = super.mapFromJson(content, Customer.class);
		assertEquals("shadow007", customer.getUsername());

	}

	@Test
	public void updateCustomer() throws Exception {

		String uri = "/customer/21";
		String putUri = "/customer";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer customer = super.mapFromJson(content, Customer.class);
		customer.setEmail("updatedMail@gm.com");

		customer.setUsername("IAmAUpdatedUserName");
		String inputJson = super.mapToJson(customer);
		MvcResult mvcResultt = mvc
				.perform(MockMvcRequestBuilders.put(putUri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int postStatus = mvcResultt.getResponse().getStatus();
		assertEquals(200, postStatus);

		String responseContent = mvcResultt.getResponse().getContentAsString();
		Customer c = super.mapFromJson(responseContent, Customer.class);
		assertEquals("updatedMail@gm.com", c.getEmail());

	}
	
	@Test
	public void insertCustomer() throws Exception {

		String uri = "/customer";
		Customer customer = new Customer(45465);
	 
		customer.setEmail("customer@g.com");
		customer.setMobileNumber("9182829300");
		customer.setPassword("kishoreTheGreat");
		customer.setUsername("krish");
		String inputJson = mapToJson(customer);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
