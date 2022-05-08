package com.spring.microservices.vo;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("BeanFilter")
public class DynamicFilteringVO {

	private String id;
	private String firstName;
	private String surName;
	private String Email;
	private String Password;

	public DynamicFilteringVO() {
		super();
	}

	public DynamicFilteringVO(String id, String firstName, String surName, String Email, String Password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.Email = Email;
		this.Password = Password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail(){
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
}
