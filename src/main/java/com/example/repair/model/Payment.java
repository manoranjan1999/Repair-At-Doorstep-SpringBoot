package com.example.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "payment_status")
	@Enumerated(EnumType.ORDINAL)
	private PaymentStatus paymentStatus;
	
	@Column(name = "total_amount")
	private int totalAmount;
	
	@Column(name = "payment_gateway_type")
	@Enumerated(EnumType.ORDINAL)
	private PaymentStatus paymentGatewayType;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentStatus getPaymentGatewayType() {
		return paymentGatewayType;
	}

	public void setPaymentGatewayType(PaymentStatus paymentGatewayType) {
		this.paymentGatewayType = paymentGatewayType;
	}


	
	

}
