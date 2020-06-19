package com.example.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
public class Parts {
	
	@Id
	@GeneratedValue
	@Column(name = "parts_id")
	private int partsId;
	
	@Column(name = "parts_name")
	private String partsName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "service_charge")
	private double serviceCharge;
	
	@Column(name = "Qty")
	private int quantity;
	
	@Column(name = "parts_description")
	private String partsDescription;
	

	public int getPartsId() {
		return partsId;
	}

	public String getPartsDescription() {
		return partsDescription;
	}

	public void setPartsDescription(String partsDescription) {
		this.partsDescription = partsDescription;
	}

	public void setPartsId(int partsId) {
		this.partsId = partsId;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	


}
