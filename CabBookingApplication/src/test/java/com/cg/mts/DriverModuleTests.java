package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mts.entities.Driver;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class DriverModuleTests extends AbstractTest {

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getStausCode() throws Exception {
		String uri = "/driver/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
// Get cab by ID
// Update Cab
// Delete Cab
// Insert

	@Test
	public void deleteDriver() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.delete("/driver/9").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void getDriverById() throws Exception {
		String uri = "/driver/10";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		Driver d = mapFromJson(content, Driver.class);

		assertEquals("sai12", d.getUsername());
	}

	@Test
	public void insertDriver() throws Exception {

		String uri = "/driver";
		Driver driver = new Driver(444, "AP05B15", null, 4.5f);
		driver.setEmail("maddala@gm.cm");
		driver.setUsername("maddala");
		driver.setPassword("password");
		driver.setMobileNumber("7358160589");
		String inputJson = mapToJson(driver);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
