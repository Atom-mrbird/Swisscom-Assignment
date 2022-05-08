package com.spring.microservices.vo;

import javax.validation.constraints.Size;

public class UserVO {

	private Integer id;
	@Size(min = 2, message = "First Name should be at least 2 character")
	private String firstName;
	private String lastName;
	private String Email;
	private String Password;
	private String address;
	private String account;

	public UserVO(Integer id, String firstName, String lastName, String Email,String Password,String address,String account) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.Password = Password;
		this.address = address;
		this.account = account;
	}

	public UserVO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ",Email=" +Email+ ",Password"+ Password + ",Address"+address+ ",account type" + account + "]";
	}
}
