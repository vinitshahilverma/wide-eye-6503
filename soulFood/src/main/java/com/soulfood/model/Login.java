package com.soulfood.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int loginId;
	
	private String apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
	
	private LocalDateTime keyExpiryDate = LocalDateTime.now().plusHours(4);
	
	private LoginStatus status = LoginStatus.LOGGED_IN;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JsonIgnore
	public void newLogin() {
		this.apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		this.keyExpiryDate = LocalDateTime.now().plusHours(4);
		this.status = LoginStatus.LOGGED_IN;
	}
	
	@JsonIgnore
	public void revokeLogin() {
		this.apiKey = null;
		this.keyExpiryDate = null;
		this.status = LoginStatus.LOGGED_OUT;
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}
//	

	public LocalDateTime getKeyExpiryDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatus(LoginStatus loggedIn) {
		// TODO Auto-generated method stub
		
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setKeyExpiryDate(LocalDateTime keyExpiryDate) {
		this.keyExpiryDate = keyExpiryDate;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	
	
}