package com.example.repair.dto;

public class PaymentStatusDTO {
	private int srId;
	private String transactionId;
	private int grandTotal;
	private boolean status;
	public PaymentStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentStatusDTO(int srId, String transactionId, int grandTotal, boolean status) {
		super();
		this.srId = srId;
		this.transactionId = transactionId;
		this.grandTotal = grandTotal;
		this.status = status;
	}
	public int getSrId() {
		return srId;
	}
	public void setSrId(int srId) {
		this.srId = srId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}