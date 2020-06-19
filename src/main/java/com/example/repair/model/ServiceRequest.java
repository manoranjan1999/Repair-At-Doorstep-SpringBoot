package com.example.repair.model;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "service_request")
@SequenceGenerator(name = "seq", initialValue = 100000, allocationSize = 1)
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "service_request_id")
	private int serviceRequestId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "model_number")
	private String modelNumber;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "product_image")
	private Blob productImage;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "service_provider_id")
	private int serviceProviderId;

	@Column(name = "address_id")
	private int addressId;

	@Column(name = "technician_id")
	private int technicianId;

	@Column(name = "date_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate localDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "feedbackId")
	private CustomerFeedback feedback;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public CustomerFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(CustomerFeedback feedback) {
		this.feedback = feedback;
	}

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}

}
