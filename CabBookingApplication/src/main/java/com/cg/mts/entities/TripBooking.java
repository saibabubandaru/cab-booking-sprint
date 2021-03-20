package com.cg.mts.entities;

import java.time.LocalDateTime;

public class TripBooking {
	private int tripBookingId;
	private int customerId;
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
}