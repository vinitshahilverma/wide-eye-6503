package com.soulfood.model;

import com.soulfood.model.Customer;

public class CustomerDTOForHttpRequest {

	private Customer customer;
	private CustomerToken cToken;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerToken getcToken() {
		return cToken;
	}
	public void setcToken(CustomerToken cToken) {
		this.cToken = cToken;
	}
	public CustomerDTOForHttpRequest(Customer customer, CustomerToken cToken) {
		super();
		this.customer = customer;
		this.cToken = cToken;
	}
	public CustomerDTOForHttpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerDTOForHttpRequest [customer=" + customer + ", cToken=" + cToken + "]";
	}
	
	
}
