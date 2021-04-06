package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.mts.entities.Cab;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Driver;
import com.cg.mts.entities.TripBooking;

@SpringBootTest
public class TripBookingApplicationTests extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
    /**
     * insertTrip
     * @throws Exception
     */
	@Test
	public void insertTrip() throws Exception {
		String uri = "/tripbooking";
		Customer c = new Customer();
		c.setCustomerId(1);
		Driver d = new Driver();
		d.setDriverId(3);
		Cab cab = new Cab(1, "ertiga", 9);
		d.setCab(cab);

		TripBooking tripBook = new TripBooking(3, c, d, "golden avenue", "balaji nagar", null, null, true, 23.5f,
				210.3f);
		String inputJson = super.mapToJson(tripBook);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		TripBooking trip = super.mapFromJson(content, TripBooking.class);
		assertEquals(3, trip.getTripBookingId());
	}
    /**
     * updateTrip
     * @throws Exception
     */
	@Test
	public void updateTrip() throws Exception {
		String uri = "test/tripbooking/1";
		String postUri = "/tripbooking";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		TripBooking tripbook = super.mapFromJson(content, TripBooking.class);
		tripbook.setBill(290);
		String inputJson = super.mapToJson(tripbook);
		MvcResult mvcResultt = mvc.perform(
				MockMvcRequestBuilders.put(postUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int postStatus = mvcResultt.getResponse().getStatus();
		assertEquals(200, postStatus);
		String responseContent = mvcResultt.getResponse().getContentAsString();
		TripBooking a = super.mapFromJson(responseContent, TripBooking.class);
		assertEquals(290, a.getBill());

	}
    /**
     * deleteTrip
     * @throws Exception
     */
	@Test
	public void deleteTrip() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.delete("/trip/tripbooking/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
