package com.example.repair.dto;


public class FeedbackDTO {
	private String userName;
	private int stars;
	private String feedbackTexts;
	private String productName;
	private String Description;
	public FeedbackDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedbackDTO(String userName, int stars, String feedbackTexts, String productName, String description) {
		super();
		this.userName = userName;
		this.stars = stars;
		this.feedbackTexts = feedbackTexts;
		this.productName = productName;
		Description = description;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getFeedbackTexts() {
		return feedbackTexts;
	}
	public void setFeedbackTexts(String feedbackTexts) {
		this.feedbackTexts = feedbackTexts;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}