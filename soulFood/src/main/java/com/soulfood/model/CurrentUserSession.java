package com.soulfood.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CurrentUserSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	@NotNull
	private Integer customerId;
	
	@NotNull
	private String uuid;
	
	private LocalDateTime localDateTime;

	
	
	public CurrentUserSession(Integer customerId, String uuid, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}



	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}



	@Override
	public String toString() {
		return "CurrentUserSession [id=" + id + ", customerId=" + customerId + ", uuid=" + uuid + ", localDateTime="
				+ localDateTime + "]";
	}



	public CurrentUserSession() {
		super();
	}

	

	

	
}
