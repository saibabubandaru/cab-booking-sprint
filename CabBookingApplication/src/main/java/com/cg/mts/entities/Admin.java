package com.cg.mts.entities;

public class Admin extends AbstractUser {
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Admin() {
	}

	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}
	
	
}