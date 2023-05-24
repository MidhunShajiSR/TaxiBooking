package com.candella.entity;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Service {

	private int serviceId;
	private Customer customer;
	private Driver driver;
	private String from;
	private String to;
	private Date dateRide;
//	private LocalDate localdate;
	private String timeRide;
	private double distance;
	private double price;
	public Service(int serviceId, Customer customer, Driver driver, String from, String to, Date dateRide,
			String timeRide, double distance, double price) {
		super();
		this.serviceId = serviceId;
		this.customer = customer;
		this.driver = driver;
		this.from = from;
		this.to = to;
		this.dateRide = dateRide;
		this.timeRide = timeRide;
		this.distance = distance;
		this.price = price;
	}
	
	public Service(int serviceId) {
		super();
		this.serviceId = serviceId;
	}
	
	public Service(Driver driver, String from, String to, Date dateRide,
			String timeRide, double distance, double price) {
		super();
		 
		this.driver = driver;
		this.from = from;
		this.to = to;
		this.dateRide = dateRide;
		this.timeRide = timeRide;
		this.distance = distance;
		this.price = price;
	}
	public Service() {
		
	}
	

//	public Service(Driver driver2, String sPoint, String dPoint, Date date2, String time, double distance2,
//			double price2) {
//		// TODO Auto-generated constructor stub
//	}


	public Service(String driver, String sPoint, String dPoint, Date date2, String time, double distance2,
			double price2) {
		// TODO Auto-generated constructor stub
		super();
		 
		//this.driver = driver;
		this.from = sPoint;
		this.to = dPoint;
		this.dateRide = date2;
		this.timeRide = time;
		this.distance = distance2;
		this.price = price2;
	}

	public Service(Driver driver, String sPoint, String dPoint, String date2, String time, double distance2,
			double price2) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.from = sPoint;
		this.to = dPoint;
		//this.dateRide = date2;
		this.timeRide = time;
		this.distance = distance2;
		this.price = price2;
	}

	public Service(String string, Customer customer2, Driver driver2, String string2, String string3,
			java.sql.Date date, String string4, double double1, double double2) {
		// TODO Auto-generated constructor stub
	}

//	public Service(Driver driver2, String sPoint, String dPoint, LocalDate localDate, String time, double distance2,
//			double price2) {
//		// TODO Auto-generated constructor stub
//		this.driver = driver2;
//		this.from = sPoint;
//		this.to = dPoint;
//		//this.dateRide = localDate;
//		this.localdate = localDate;
//		this.timeRide = time;
//		this.distance = distance2;
//		this.price = price2;
//	}

	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDateRide() {
		return dateRide;
	}
	public void setDateRide(Date dateRide) {
		this.dateRide = dateRide;
	}
	public String getTimeRide() {
		return timeRide;
	}
	public void setTimeRide(String timeRide) {
		this.timeRide = timeRide;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
//	public LocalDate getLocaldate() {
//		return localdate;
//	}
//
//	public void setLocaldate(LocalDate localdate) {
//		this.localdate = localdate;
//	}

	
		
}
