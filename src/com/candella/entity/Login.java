package com.candella.entity;

public class Login {

	private Customer loginId;
	private Customer password;
	
	public Login(Customer loginId, Customer password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	public Customer getLoginId() {
		return loginId;
	}
	public void setLoginId(Customer loginId) {
		this.loginId = loginId;
	}
	public Customer getPassword() {
		return password;
	}
	public void setPassword(Customer password) {
		this.password = password;
	}
	
}	 