package com.example.repair.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visiting_details")
public class Visit {
	
	@Id
	@GeneratedValue
	@Column(name = "visit_id")
	private int visitId;
	
	@Column(name = "service_request_id")
	private int serviceRequestId;
	
	@Column(name = "visiting_message")
	private String visitingMessage;
	
	 @Column(name = "date_time")
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private LocalDate localDate;
	 
	 @Column(name = "status")
	 @Enumerated(EnumType.ORDINAL)
	 private Status status;

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getVisitingMessage() {
		return visitingMessage;
	}

	public void setVisitingMessage(String visitingMessage) {
		this.visitingMessage = visitingMessage;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
