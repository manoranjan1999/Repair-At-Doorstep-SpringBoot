package com.example.repair.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "service_request_id")
	private int serviceRequestId;
	
	@OneToMany(targetEntity = Parts.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id",referencedColumnName = "order_id")
	private List<Parts> parts;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public List<Parts> getParts() {
		return parts;
	}

	public void setParts(List<Parts> parts) {
		this.parts = parts;
	}
	
	

}
