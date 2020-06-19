package com.example.repair.exception;

public class UserAlreadyRegisteredException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6986984289656508916L;
	private String emailId;

	
	public UserAlreadyRegisteredException(String emailId) {
		super();
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
