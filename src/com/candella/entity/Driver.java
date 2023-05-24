package com.candella.entity;

import java.util.Date;

public class Driver {

	private String driverId;
	private Car car; 
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobileNo;
	private String mailId;
	private String driverLicience;
	private String available;
	private String password;
	 
		
	public Driver(String driverId, Car car, String firstName, String lastName, String gender, Date dob, String mobileNo,
			String mailId, String driverLicience, String available, String password) {
		super();
		this.driverId = driverId;
		this.car = car;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.driverLicience = driverLicience;
		this.available = available;
		this.password = password;
	}
	public Driver(Car car, String firstName, String lastName, String gender, Date dob, String mobileNo,
			String mailId, String driverLicience, String available, String password) {
		super();
		this.car = car;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.driverLicience = driverLicience;
		this.available = available;
		this.password = password;
	}
 
	public Driver(String driverId, String firstName, String lastName, String gender, Date dob, String mobileNo,
			String mailId, String driverLicience, String available, String password) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.mailId = mailId;
		this.driverLicience = driverLicience;
		this.available = available;
		this.password = password;
	}
	
	public Driver(Car car) {
		super();
	}
	

public Driver(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Driver() {
		super();
	}
//	public Driver() {
//	
//}
//	public Driver(String string, Driver driver, String string2, String string3, String string4, java.sql.Date date,
//			String string5, String string6, String string7, String string8, String string9) {
//		// TODO Auto-generated constructor stub
//	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getDriverLicience() {
		return driverLicience;
	}
	public void setDriverLicience(String driverLicience) {
		this.driverLicience = driverLicience;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCarId(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCar(Object car2) {
		// TODO Auto-generated method stub
		
	}
	 
	
}
