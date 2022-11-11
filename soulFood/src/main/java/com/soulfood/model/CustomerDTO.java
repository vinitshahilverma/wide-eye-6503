package com.soulfood.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//import lombok.Data;

//@Data
//@Entity
public class CustomerDTO {
	
	@NotNull
//	@Pattern(regexp="(^$|[0-9]{10})")
    private Long mobileNo;
	
	@NotNull
//	@Pattern(regexp="^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
	private String password;

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerDTO [mobileNo=" + mobileNo + ", password=" + password + "]";
	}

//	public CustomerDTO(@NotNull @Pattern(regexp = "(^$|[0-9]{10})") Integer mobileNo,
//			@NotNull @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$") String password) {
//		super();
//		this.mobileNo = mobileNo;
//		this.password = password;
//	}

	public CustomerDTO() {
		super();
	}

public CustomerDTO(@NotNull Long mobileNo, @NotNull String password) {
	super();
	this.mobileNo = mobileNo;
	this.password = password;
}
	
	

}
