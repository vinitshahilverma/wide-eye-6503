package com.soulfood.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", customer=" + customer + "]";
	}

	public Admin(Integer adminId, Customer customer) {
		super();
		this.adminId = adminId;
		this.customer = customer;
	}

	public Admin() {
		super();
	}
	
	
	
}
