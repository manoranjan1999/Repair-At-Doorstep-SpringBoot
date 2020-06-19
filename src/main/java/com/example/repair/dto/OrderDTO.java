package com.example.repair.dto;

public class OrderDTO {
	private int serviceRequestId;
	private int partsId;
	private String partsName;
	private double price;
	private double serviceCharge;
	private int quantity;
	public int getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public int getPartsId() {
		return partsId;
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
