package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mts.entities.Admin;

@SpringBootTest
class CabBookingApplicationTests extends AbstractTest{

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getStudent() throws Exception {
		String uri = "/admin";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		//List<Admin> list = (List<Admin>) super.mapFromJson(content, Admin.class);
		
		//assertEquals("Saurabh Sharma", stu.getName());
	}

}
