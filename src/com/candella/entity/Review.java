package com.candella.entity;

public class Review {

	private int reviewId;
	private Customer customer;
	private Driver driver;
	private String review;
	private String cmt;
	public Review(int reviewId, Customer customer,String review, String cmt) {
		super();
		this.reviewId = reviewId;
		this.customer = customer;
		this.review = review;
		this.cmt = cmt;
	}
	public Review(Customer customer2, String react, String feedback) {
		// TODO Auto-generated constructor stub
		super();
		this.customer = customer2;
		this.review = react;
		this.cmt = feedback;
	}
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Review(Customer customer2, Driver driver2, String react, String feedback) {
		// TODO Auto-generated constructor stub
		super();
		//this.reviewId = reviewId;
		this.customer = customer2;
		this.driver = driver2;
		this.review = react;
		this.cmt = feedback;
	}
	public Review(int int1, Driver driver2, Customer customer2, String string, String string2) {
		// TODO Auto-generated constructor stub
		super();
		this.reviewId = int1;
		this.customer = customer2;
		this.driver = driver2;
		this.review = string;
		this.cmt = string2;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	 
	
}
