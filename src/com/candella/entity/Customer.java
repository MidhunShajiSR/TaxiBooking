package com.candella.entity;

import java.util.Date;

public class Customer {

	private String customerId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobileNo;
	private String mailId;
	private String password;
	
	public Customer(String customerId, String firstName, String lastName, String gender, Date dob,
			String mobileNo, String mailId, String password) {
		super();
		this.customerId = customerId;
		//this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.password = password;
	}
	
	
	
	public Customer() {
	
	}



	public Customer(String string, String string2) {
		// TODO Auto-generated constructor stub
	}


	public Customer(String customerId2, String fname, String lname, String pass) {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstName, String lastName, String gender, Date dob,
			String mobileNo, String mailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.password = password;
	}

//	public Customer(String firstName, String lname, String gender2, Date dob,String num, String mail, String pass) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.dob = dob;
//	}


	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public void setDob(Object dob2) {
		// TODO Auto-generated method stub
		
	}

	
		
}
