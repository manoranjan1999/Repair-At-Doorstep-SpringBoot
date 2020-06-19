package com.example.repair.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "service_provider")
public class ServiceProvider{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_provider_id")
	private int serviceProviderId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "service_provider_name")
	private String serviceProviderName;
	
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "roles")
	private String roles;
	
	@OneToMany(targetEntity = Category.class ,cascade = CascadeType.ALL)
	@JoinColumn(name = "service_provider_id",referencedColumnName = "service_provider_id")
	private List<Category> category;
	
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "service_provider_id",referencedColumnName = "service_provider_id")
	private List<Address> address;
	
	@OneToMany(targetEntity = Technician.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "service_provider_id",referencedColumnName = "service_provider_id")
	private List<Technician> technician;

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Technician> getTechnician() {
		return technician;
	}

	public void setTechnician(List<Technician> technician) {
		this.technician = technician;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
	

}
