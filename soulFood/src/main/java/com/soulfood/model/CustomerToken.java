package com.soulfood.model;

public class CustomerToken {

	private String token;
	private Integer custId;
	private String masterToken;
	
	
	public String getMasterToken() {
		return masterToken;
	}
	public void setMasterToken(String masterToken) {
		this.masterToken = masterToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "CustomerToken [token=" + token + ", custId=" + custId + ", masterToken=" + masterToken + "]";
	}
	public CustomerToken(String token, Integer custId) {
		super();
		this.token = token;
		this.custId = custId;
	}
	public CustomerToken() {
		super();
	}
	public CustomerToken(String token, Integer custId, String masterToken) {
		super();
		this.token = token;
		this.custId = custId;
		this.masterToken = masterToken;
	}
	
	
	
}
