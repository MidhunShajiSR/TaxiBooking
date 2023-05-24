package com.candella.dao;

import java.util.List;

import com.candella.entity.Car;
import com.candella.entity.Customer;
import com.candella.entity.Driver;
import com.candella.entity.Review;
import com.candella.entity.Service;

public interface TaxiBookingDao {

	public void createAccount(Customer customer);

	public  void delete(String customer);

	public Customer display(String customerid);

	public List<Customer> listCustomer();

	public void logins(String customerId, String pass);

	public void registerDriver(Driver driver);

	public List<Driver> dispDriverDetails();

	public void driverLogin(String driverId, String pass);

	public Driver driverDisplay(String driverid);

	public void regCar(Car car);

	public Car getCar(String carId);

	public void adminLogin(String adminId, String pass);

	public List<Car> displayCar();

	public void deleteDriverall(String driver);

	public void deleteCus(String customer);

	public void deleteCar(String car);

	public void delDriver(String driver);

	public void update(Customer customer, String customerid);

	public void updateCustomers(Customer customer, String customerId);

	public void updateDriver(Driver driver, String driverId);

	public void updateCar(Car car, String carId);

	public Driver getDriver(String driverId);

	public void bookTaxi(Service service, String customerId);

	public List<Driver> driverAvail();

	public List<Service> genBill();

	public Driver getDriverName(String driverId);

	public void cusReview(String customerId, Review review, String cusFname, String cusLname);

	public List<Review> getReview();

	public Car dispCar(String carId1);

	public void cusReview2(String customerId, Review review, String driverId);

	public List<Review> getReviews();


	
}
