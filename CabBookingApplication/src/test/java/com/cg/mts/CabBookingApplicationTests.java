package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mts.entities.Admin;
 	
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CabBookingApplicationTests extends AbstractTest{

	@Override
	
	@BeforeAll
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getAdminUsername() throws Exception {
		String uri = "/admin/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Admin admin = super.mapFromJson(content, Admin.class);
		assertEquals("admin1", admin.getUsername());
	}
	@Test
	public void getStausCode() throws Exception {
		String uri = "/admin";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
