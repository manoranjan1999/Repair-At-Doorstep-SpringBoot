package com.example.repair.dto;

public class TechnicianAddingDto {
	private int serviceProviderId;
	private String firstName;
	private String lastName;
	private String qualification;
	private String email;
	private String phone_Number;
	private String address;

	public TechnicianAddingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechnicianAddingDto(int serviceProviderId, String firstName, String lastName, String qualification,
			String email, String phone_Number, String address) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.qualification = qualification;
		this.email = email;
		this.phone_Number = phone_Number;
		this.address = address;
	}

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
