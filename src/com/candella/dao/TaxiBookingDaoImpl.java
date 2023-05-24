package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.sql.DataSource;
//import java.sql.Date;
import com.canddella.connectionpool.ConnectionPool;
import com.candella.entity.Car;
import com.candella.entity.Customer;
import com.candella.entity.Driver;
import com.candella.entity.Login;
import com.candella.entity.Review;
import com.candella.entity.Service;

public class TaxiBookingDaoImpl implements TaxiBookingDao {

	@Override
	public void createAccount(Customer customer) {
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into customer(customer_id,first_name,last_name,gender,dob,mobile_no,mail_id,password)"
					+ "values(?,?,?,?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, customer.getCustomerId());
			prepstmt.setString(2, customer.getFirstName());
			prepstmt.setString(3, customer.getLastName());
			prepstmt.setString(4, customer.getGender());
			prepstmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));
			prepstmt.setString(6, customer.getMobileNo());
			prepstmt.setString(7, customer.getMailId());
			prepstmt.setString(8, customer.getPassword());

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String customer) {
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "delete from customer where customer_id =\"" + customer + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer display(String customerid) {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "select * from customer where customer_id =\"" + customerid + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();

			while (resultSet.next()) {
				customer = (new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8)));

			}

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void update(Customer customer, String customerid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null; // ,
		try {

			String selectSQL = "update customer set customer_id = ? ,first_name = ?, last_name = ? , gender = ?, dob = ?, mobile_no =?, "
					+ "mail_id = ?, password = ? where customer_id = '" + customerid + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, customerid);// getCustomerId())
			prepstmt.setString(2, customer.getFirstName());
			prepstmt.setString(3, customer.getLastName());
			prepstmt.setString(4, customer.getGender());
			prepstmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));
			prepstmt.setString(6, customer.getMobileNo());
			prepstmt.setString(7, customer.getMailId());
			prepstmt.setString(8, customer.getPassword());
			;

			prepstmt.execute();
			prepstmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

//	@Override
	public List<Customer> listCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from customer";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				customerList.add(new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8)));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public void logins(String customerId, String pass) {

		Connection connection = null;
		PreparedStatement prepstmt = null;
		Boolean isUser;

		try {
			String selectSQL = "select * from customer where customer_id='" + customerId + "' and password='" + pass
					+ "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();
			if (resultSet.next()) {
				isUser = true;
				System.out.println(" ");
				System.out.println("********************");
				System.out.println("login is successfull");
			} else {
				System.out.println("Invalid User Name or Passwors");
			}
			prepstmt.execute();
			prepstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void registerDriver(Driver driver) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into driver(driver_id,car_id,first_name,last_name,gender,dob,mobile_no,mail_id,driver_licience,available,password)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, driver.getDriverId());
			prepstmt.setString(2, driver.getCar().getCarId());
			prepstmt.setString(3, driver.getFirstName());
			prepstmt.setString(4, driver.getLastName());
			prepstmt.setString(5, driver.getGender());
			prepstmt.setDate(6, new java.sql.Date(driver.getDob().getTime()));
			prepstmt.setString(7, driver.getMobileNo());
			prepstmt.setString(8, driver.getMailId());
			prepstmt.setString(9, driver.getDriverLicience());
			prepstmt.setString(10, driver.getAvailable());
			prepstmt.setString(11, driver.getPassword());

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Driver> dispDriverDetails() {
		// TODO Auto-generated method stub
		List<Driver> driverList = new ArrayList<Driver>();
		Connection connection = null;
		// Car car = new Car();
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from driver";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				Car car = new Car();
				car.setCarId(resultSet.getString(2));
				driverList.add(new Driver(resultSet.getString(1), car, resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driverList;
	}

	@Override
	public void driverLogin(String driverId, String pass) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Boolean isUser;

		try {
			String selectSQL = "select * from driver where driver_id='" + driverId + "' and password='" + pass + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();
			if (resultSet.next()) {
				isUser = true;
				System.out.println(" ");
				System.out.println("********************");
				System.out.println("login is successfull");
			} else {
				System.out.println("Invalid User Name or Passwors");
			}
			prepstmt.execute();
			prepstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Driver driverDisplay(String driverid) {
		// TODO Auto-generated method stub
		Driver driver = null;
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Car car = new Car();
		try {
			String selectSQL = "select * from driver where driver_id =\"" + driverid + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();

			while (resultSet.next()) {
				car.setCarId(resultSet.getString(2));
				driver = (new Driver(resultSet.getString(1), car, resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));

			}

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	@Override
	public void regCar(Car car) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into car(car_id,car_no,model_name,model_description,mfg_year)"
					+ "values(?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, car.getCarId());
			prepstmt.setString(2, car.getCarNo());
			prepstmt.setString(3, car.getModelName());
			prepstmt.setString(4, car.getModelDescription());
			prepstmt.setString(5, car.getMfgYear());
			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car getCar(String carId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Car car = null;
		try {
			String insertTableSQL = "select * from car where car_id= ?";// \"" + carId + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(insertTableSQL);
			prepstmt.setString(1, carId);
			ResultSet resultSet = prepstmt.executeQuery();
			while (resultSet.next()) {
				car = new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			}
			prepstmt.execute();
			connection.close();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return car;

	}

	@Override
	public void adminLogin(String adminId, String pass) {
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Boolean isUser;

		try {
			String selectSQL = "select * from admin where admin_id='" + adminId + "' and password='" + pass + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();
			if (resultSet.next()) {
				isUser = true;
				System.out.println(" ");
				System.out.println("********************");
				System.out.println("login is successfull");
			} else {
				System.out.println("Invalid User Name or Passwors");
			}
			prepstmt.execute();
			prepstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Car> displayCar() {
		// TODO Auto-generated method stub
		List<Car> carList = new ArrayList<Car>();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from car";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				carList.add(new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5)));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carList;
	}

	@Override
	public void deleteCus(String customer) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "delete from customer where customer_id =\"" + customer + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDriverall(String driver) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "delete from driver where driver_id =\"" + driver + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCar(String car) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "delete from car where car_id =\"" + car + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delDriver(String driver) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "delete from car where car_id =\"" + driver + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomers(Customer customer, String customerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null; // ,
		try {

			String selectSQL = "update customer set customer_id = ? ,first_name = ?, last_name = ? , gender = ?, dob = ?, mobile_no =?, mail_id = ?, password = ? where customer_id = '"
					+ customerId + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, customerId);// getCustomerId())
			prepstmt.setString(2, customer.getFirstName());
			prepstmt.setString(3, customer.getLastName());
			prepstmt.setString(4, customer.getGender());
			prepstmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));
			prepstmt.setString(6, customer.getMobileNo());
			prepstmt.setString(7, customer.getMailId());
			prepstmt.setString(8, customer.getPassword());
			;

			prepstmt.execute();
			prepstmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void updateDriver(Driver driver, String driverId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "update driver set driver_id = ?,car_id = ?, first_name = ?, last_name = ?, gender = ?, "
					+ "dob = ?, mobile_no = ?, mail_id = ?, driver_licience = ?, available =?, password =? where driver_id='"
					+ driverId + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, driverId);
			prepstmt.setString(2, driver.getCar().getCarId());
			// prepstmt.setString(2, carId);
			prepstmt.setString(3, driver.getFirstName());
			prepstmt.setString(4, driver.getLastName());
			prepstmt.setString(5, driver.getGender());
			prepstmt.setDate(6, new java.sql.Date(driver.getDob().getTime()));
			prepstmt.setString(7, driver.getMobileNo());
			prepstmt.setString(8, driver.getMailId());
			prepstmt.setString(9, driver.getDriverLicience());
			prepstmt.setString(10, driver.getAvailable());
			prepstmt.setString(11, driver.getPassword());

			prepstmt.execute();
			prepstmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCar(Car car, String carId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "update car set car_id = ?, car_no =?, model_name =?, model_description =?,mfg_year =? where car_id ='"
					+ carId + "'";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, carId);
			prepstmt.setString(2, car.getCarNo());
			prepstmt.setString(3, car.getModelName());
			prepstmt.setString(4, car.getModelDescription());
			prepstmt.setString(5, car.getMfgYear());
			prepstmt.execute();
			prepstmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Driver getDriver(String driverId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Driver driver = new Driver();
		Car car = new Car();

		try {
			String selectSQL = "select * from driver where driver_id=\"" + driverId + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepstmt.executeQuery();
			while (resultSet.next()) {
				car.setCarId(resultSet.getString(2));
				driver = new Driver(resultSet.getString(1), car, resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
			}
			// prepstmt.execute();
			connection.close();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return driver;

	}

	@Override
	public void bookTaxi(Service service, String customerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into service(customer_id,driver_id,from_point,to_point,date_ride,time_ride,distance,price)"
					+ "values(?,?,?,?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			// prepstmt.setInt(1,service.getServiceId());
			prepstmt.setString(1, customerId);
			prepstmt.setString(2, service.getDriver().getDriverId());
			prepstmt.setString(3, service.getFrom());
			prepstmt.setString(4, service.getTo());
			prepstmt.setDate(5, new java.sql.Date(service.getDateRide().getTime()));
			prepstmt.setString(6, service.getTimeRide());
			prepstmt.setDouble(7, service.getDistance());
			prepstmt.setDouble(8, service.getPrice());

			prepstmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Driver> driverAvail() {
		// TODO Auto-generated method stub
		List<Driver> driverList = new ArrayList<Driver>();
		Connection connection = null;
		Car car = new Car();
		PreparedStatement prepStmt = null;
		String selectSQL = "SELECT * FROM taxi.driver where  available =\"yes\";";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				car.setCarId(resultSet.getString(2));
				driverList.add(new Driver(resultSet.getString(1), car, resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driverList;
	}

	@Override
	public List<Service> genBill() {
		// TODO Auto-generated method stub
		List<Service> serviceList = new ArrayList<Service>();
		Connection connection = null;
		Driver driver = new Driver();
		Customer customer = new Customer();
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from service";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				customer.setCustomerId(resultSet.getString(2));
				driver.setDriverId(resultSet.getString(3));
				serviceList.add(new Service(resultSet.getString(1), customer, driver, resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getDouble(8),
						resultSet.getDouble(9)));

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public Driver getDriverName(String driverId) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "select first_name, last_name from driver where deiver=\"" + driverId + "\"";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();

			driver = (new Driver(resultSet.getString(3), resultSet.getString(4)));
			prepStmt.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	@Override
	public void cusReview(String customerId, Review review, String cusFname, String cusLname) {

		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into review(customer_id,fname,lname,react,cmt)" + "values(?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, customerId);
//			prepstmt.setString(2, review.getCustomer().getFirstName());
//			prepstmt.setString(3, review.getCustomer().getLastName());
			prepstmt.setString(2, cusFname);
			prepstmt.setString(3, cusLname);
			prepstmt.setString(4, review.getReview());
			prepstmt.setString(5, review.getCmt());

			prepstmt.execute();
			prepstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Review> getReview() {
		// TODO Auto-generated method stub
		List<Review> reviewList = new ArrayList<Review>();
		Connection connection = null;
		// Review review = new Review();
		// Customer customer = new Customer();
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from review";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString(2));
				customer.setFirstName(resultSet.getString(3));
				customer.setLastName(resultSet.getString(4));
				reviewList
						.add(new Review(resultSet.getInt(1), customer, resultSet.getString(5), resultSet.getString(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}

	@Override
	public Car dispCar(String carId1) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		Car car = null;
		try {
			String selectSQL = "select * from car where car_id=\"" + carId1 + "\"";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			// prepstmt.setString(1, carId1);
			ResultSet resultSet = prepstmt.executeQuery();
			while (resultSet.next()) {
				car = new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			}
			prepstmt.execute();
			connection.close();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return car;
	}

	@Override
	public void cusReview2(String customerId, Review review, String driverId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try {
			String selectSQL = "insert into reviews(driver_id,fname,lname,customer_id,cusfname,cuslname,react,cmt)"
					+ "values(?,?,?,?,?,?,?,?)";
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepstmt = connection.prepareStatement(selectSQL);
			prepstmt.setString(1, driverId);
			prepstmt.setString(2, review.getDriver().getFirstName());
			prepstmt.setString(3, review.getDriver().getLastName());
			prepstmt.setString(4, customerId);
			prepstmt.setString(5, review.getCustomer().getFirstName());
			prepstmt.setString(6, review.getCustomer().getLastName());
			// prepstmt.setString(2, cusFname);
			// prepstmt.setString(3, cusLname);
			prepstmt.setString(7, review.getReview());
			prepstmt.setString(8, review.getCmt());

			prepstmt.execute();
			prepstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Review> getReviews() {
		// TODO Auto-generated method stub
		List<Review> reviewList = new ArrayList<Review>();
		Connection connection = null;
		// Review review = new Review();
		// Customer customer = new Customer();
		PreparedStatement prepStmt = null;
		String selectSQL = "select * from reviews";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				Driver driver = new Driver();
				driver.setDriverId(resultSet.getString(2));
				driver.setFirstName(resultSet.getString(3));
				driver.setLastName(resultSet.getString(4));
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString(5));
				customer.setFirstName(resultSet.getString(6));
				customer.setLastName(resultSet.getString(7));
				reviewList.add(new Review(resultSet.getInt(1), driver, customer, resultSet.getString(8),
						resultSet.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}


}
