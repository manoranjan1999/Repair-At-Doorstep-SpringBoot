package com.example.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer_feedback")
public class CustomerFeedback {
	@Id
	@GeneratedValue
	private int feedbackId;
	
	@Column(name = "stars")
	private int stars;
	
	@Column(name = "feedback_text")
	private String feedbackText;

	public CustomerFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerFeedback(int feedbackId, int stars, String feedbackText) {
		super();
		this.feedbackId = feedbackId;
		this.stars = stars;
		this.feedbackText = feedbackText;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}
}