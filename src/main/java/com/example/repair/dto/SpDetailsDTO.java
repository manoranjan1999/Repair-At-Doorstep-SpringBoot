package com.example.repair.dto;

public class SpDetailsDTO {

	private String serviceProviderName;
	private String emailId;
	public SpDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpDetailsDTO(String serviceProviderName, String emailId) {
		super();
		this.serviceProviderName = serviceProviderName;
		this.emailId = emailId;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}