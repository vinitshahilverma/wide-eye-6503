package com.soulfood.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	@Min(15)
	private Integer age;

	@NotNull
	private String gender;

	@Pattern(regexp = "[0-9]{10}",message="Mobile should be 10 digit")
	private String mobileNumber;

	@Email
	private String email;

	@NotNull
	@Size(min=5, max=12, message="Password length should be between 5 to 12")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private FoodCart cart;

	public Customer() {
	}

	public Customer(Integer customerId, String firstName, String lastName, Integer age, String gender, String mobileNumber, String email, String password, Address address, FoodCart cart) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = cart;
	}

	/*public Customer(Integer customerId, @NotNull String firstName, @NotNull String lastName, @NotNull @Min(15) Integer age,
					@NotNull String gender, Long mobileNumber, @Email String email,
					@NotNull @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})") String password,
					Address address, Cart cart) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = cart;
	}*/

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FoodCart getCart() {
		return cart;
	}

	public void setCart(FoodCart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", mobileNumber=" + mobileNumber +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", address=" + address +
				", cart=" + cart +
				'}';
	}
}
