package com.candella.entity;

public class Car {

	private String 	carId;
	private String carNo;
	private String modelName;
	private String modelDescription;
	private String mfgYear;
	//private String active;
	public Car(String carId, String carNo, String modelName, String modelDescription, String mfgYear) {
		super();
		this.carId = carId;
		this.carNo = carNo;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.mfgYear = mfgYear;
		//this.active = active;
	}
	public Car(String carNo, String modelName, String modelDescription, String mfgYear) {
		super();
		this.carNo = carNo;
		this.modelName = modelName;
		this.modelDescription = modelDescription;
		this.mfgYear = mfgYear;
	}
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public String getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(String mfgYear) {
		this.mfgYear = mfgYear;
	}
//	public String getActive() {
//		return active;
//	}
//	public void setActive(String active) {
//		this.active = active;
//	}
	
	
	 	 	
}
