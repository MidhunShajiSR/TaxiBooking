package com.candella.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
//import java.text.DateFormat;
import java.util.List;
import java.util.Random;
//import java.sql.Date;
import java.util.Scanner;

import com.candella.dao.TaxiBookingDao;
import com.candella.dao.TaxiBookingDaoImpl;
import com.candella.entity.Car;
import com.candella.entity.Customer;
import com.candella.entity.Driver;
import com.candella.entity.Review;
import com.candella.entity.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TaxiBookingServiceDaoImpl implements TaxiBookingServiceDao {
	private static List<Customer> customerList = new ArrayList();
	private static List<Driver> driverList = new ArrayList();
	private static List<Car> carList = new ArrayList();
	private List<Review> review = new ArrayList();

	static Service serviceTemp;
	static String fname, lname, gender, dob, num, mail, pass, customer;
	static Date date2;
	static Car car;
	static String carId1, carNo, carName, carDesc, mfgYear;
	static Driver cusTemp;
	static String react;
	static int otp;
	static String driverId;

	@Override
	public void createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		String customerId = scanner.nextLine();
		System.out.println("Enter customer first name : ");
		String fName = scanner.nextLine();
		String regx = ("[a-z]*");
		if (fName.matches(regx) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter customer second name : ");
		String sName = scanner.nextLine();
		String regx1 = ("[a-z]*");
		if (sName.matches(regx1) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter customer Gender");
		String gender = scanner.nextLine();
		String regx2 = ("male|female");
		if (gender.matches(regx2) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Date of Birth (yyyy-MM-dd) : ");
		String dob = scanner.nextLine();
		// String regx3 =("([0-9]{4}-(0[1-9]|1[0-2])-0[1-9]|1[0-9]|2[0-9]|3[0-1])");
//		String regx3 =("((?:19|20)\\\\d\\\\d)/(0?[1-9]|1[012])/([12][0-9]|3[01]|0?[1-9])");
//		if (dob.matches(regx3)== false) {		
//				System.out.println("invalid input"); 
//			}
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = dateFormat1.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter customer Mobile No: :");
		String num = scanner.nextLine();
		String regx4 = ("[6-9]{1}[1-9]{9}||[+][1][9]//s[6-9]{1}[1-9]{9}");
		if (num.matches(regx4) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Mail Id : ");
		String mail = scanner.nextLine();
		String regx5 = ("\\D*\\d*[@]\\D*[.]\\D{3}");
		if (mail.matches(regx5) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Password : ");
		String pass = scanner.nextLine();
//		String regx6 =("\\D\\d{4,10}");
//		if (pass.matches(regx6)== false) {		
//			System.out.println("invalid input"); 
//		}

		Customer customer = new Customer(customerId, fName, sName, gender, date1, num, mail, pass);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.createAccount(customer);
		System.out.println("");
		System.out.println("******** Registration Successful ***********");
		System.out.println("");
		System.out.println("******** Please Login ************");
		System.out.println("");
		logins();
	}

	public void delete(String customerId) {
		Scanner scanner = new Scanner(System.in);

		String customer = customerId;
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.delete(customer);

	}

	public void deleteCus() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the CustomerId : ");
		String customer = scanner.nextLine();
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.deleteCus(customer);
	}

	public void display(String customerId) {
		Scanner scanner = new Scanner(System.in);

		String customerid = customerId;
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		// taxiBookingDoa.display(customer);
		Customer customer = taxiBookingDoa.display(customerid);
		System.out.println("Id" + "     " + "FirstName" + "   " + "LastName" + "     " + "Gender" + "   " + "Dob"
				+ "     " + "Mobile_No" + "   " + "Mail Id" + "   " + "Password");
		System.out.println("  ");
		System.out.println(customer.getCustomerId() + "    " + customer.getFirstName() + "    " + customer.getLastName()
				+ "  " + customer.getGender() + "   " + customer.getDob() + "    " + customer.getMobileNo() + "   "
				+ customer.getMailId() + "   " + customer.getPassword());
		System.out.println(" ");
	}

	public void update(String customerId) {

		char ch;
		Scanner scanner = new Scanner(System.in);
		Customer customer2 = new Customer();
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		Customer customer1 = taxiBookingDoa.display(customerId);
		display(customerId);

		System.out.println("1. First Name");
		System.out.println("2. Second Name");
		System.out.println("3. Gender");
		System.out.println("4. DOB");
		System.out.println("5. Mobile No:");
		System.out.println("6. Mail Id");
		System.out.println("7. Password");

		// System.out.println("enter");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			System.out.println("Enter firstname : ");
			fname = scanner.nextLine() + scanner.nextLine();
			break;
		case 2:
			System.out.println("Enter Last name : ");
			lname = scanner.nextLine() + scanner.nextLine();
			break;
		case 3:
			System.out.println("Enter gender : ");
			gender = scanner.nextLine() + scanner.nextLine();
			break;
		case 4:
			System.out.println("Enter customer Date of Birth (yyyy-MM-dd) : ");
			dob = scanner.nextLine() + scanner.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// Date date2 = null;
			try {
				date2 = dateFormat.parse(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Enter mobile no : ");
			num = scanner.nextLine() + scanner.nextLine();
			break;
		case 6:
			System.out.println("Enter mail id : ");
			mail = scanner.nextLine() + scanner.nextLine();
			break;
		case 7:
			System.out.println("Enter password : ");
			pass = scanner.nextLine() + scanner.nextLine();
			break;
		default:
			throw new IllegalArgumentException("wrong choice");
		}

		// System.out.println("name = "+fname+"*******##$%%^^^$#33");
		customer2.setFirstName((fname != null) ? fname : customer1.getFirstName());
		customer2.setLastName((lname != null) ? lname : customer1.getLastName());
		customer2.setGender((gender != null) ? gender : customer1.getGender());
		customer2.setDob((date2 != null) ? date2 : customer1.getDob());
		customer2.setMobileNo((num != null) ? num : customer1.getMobileNo());
		customer2.setMailId((mail != null) ? mail : customer1.getMailId());
		customer2.setPassword((pass != null) ? pass : customer1.getPassword());
		// taxiBookingDoa = new TaxiBookingDaoImpl();

		taxiBookingDoa.update(customer2, customerId);
		System.out.println(" ");
		display(customerId);
		System.out.println(" ");

	}

	public void updateCustomers() {

		char ch;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the CustomerId : ");
		String customerId = scanner.nextLine();
		Customer customer2 = new Customer();
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		Customer customer1 = taxiBookingDoa.display(customerId);
		display(customerId);

		System.out.println("1. First Name");
		System.out.println("2. Second Name");
		System.out.println("3. Gender");
		System.out.println("4. DOB");
		System.out.println("5. Mobile No:");
		System.out.println("6. Mail Id");
		System.out.println("7. Password");

		// System.out.println("enter");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			System.out.println("Enter firstname : ");
			fname = scanner.nextLine() + scanner.nextLine();
			break;
		case 2:
			System.out.println("Enter Last name : ");
			lname = scanner.nextLine() + scanner.nextLine();
			break;
		case 3:
			System.out.println("Enter gender : ");
			gender = scanner.nextLine() + scanner.nextLine();
			break;
		case 4:
			System.out.println("Enter customer Date of Birth (yyyy-MM-dd) : ");
			dob = scanner.nextLine() + scanner.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// Date date2 = null;
			try {
				date2 = dateFormat.parse(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Enter mobile no : ");
			num = scanner.nextLine() + scanner.nextLine();
			break;
		case 6:
			System.out.println("Enter mail id : ");
			mail = scanner.nextLine() + scanner.nextLine();
			break;
		case 7:
			System.out.println("Enter password : ");
			pass = scanner.nextLine() + scanner.nextLine();
			break;
		default:
			throw new IllegalArgumentException("wrong choice");
		}

		customer2.setFirstName((fname != null) ? fname : customer1.getFirstName());
		customer2.setLastName((lname != null) ? lname : customer1.getLastName());
		customer2.setGender((gender != null) ? gender : customer1.getGender());
		customer2.setDob((date2 != null) ? date2 : customer1.getDob());
		customer2.setMobileNo((num != null) ? num : customer1.getMobileNo());
		customer2.setMailId((mail != null) ? mail : customer1.getMailId());
		customer2.setPassword((pass != null) ? pass : customer1.getPassword());
		// taxiBookingDoa = new TaxiBookingDaoImpl();

		taxiBookingDoa.updateCustomers(customer2, customerId);

	}

	private static List<Customer> dispCusDetails() {

		Scanner scanner = new Scanner(System.in);
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		List<Customer> customerList = taxiBookingDoa.listCustomer();
		System.out.println(" ");
		System.out.println("Id" + "     " + "FirstName" + "   " + "LastName" + "     " + "Gender" + "   " + "Dob"
				+ "     " + "Mobile_No" + "   " + "Mail Id" + "   " + "Password");
		System.out.println("  ");
		for (Customer customer : customerList)
			System.out.println(customer.getCustomerId() + "   " + customer.getFirstName() + "   "
					+ customer.getLastName() + "   " + customer.getGender() + "  " + customer.getDob() + "  "
					+ customer.getMobileNo() + "      " + customer.getMailId() + "     " + customer.getPassword());
		System.out.println("  ");
		return customerList;
	}

	@Override
	public void logins() {

		char ch;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the CustomerId : ");
		String customerId = scanner.nextLine();

		System.out.println("Enter the password : ");
		String pass = scanner.nextLine();

		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		taxiBookingDoa.logins(customerId, pass);

		System.out.println("********************");
		System.out.println(" ");
		do {
			System.out.println(" ");
			System.out.println("1.display  2.delete  3.update 4.BookTaxi 5. Payment 6.Feedback 7.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				display(customerId);
				break;
			case 2:
				delete(customerId);
				break;
			case 3:
				update(customerId);
				break;
			case 4:
				bookTaxi(customerId);
				break;
			case 5:
				payment();
				break;
			case 6:
				cusReview(customerId);
				break;
			case 7:
				break;
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue (Y/N) ");
			ch = scanner.next().charAt(0);
		} while ((ch == 'Y') || (ch == 'y'));

	}

	public void registerDriver() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter driver Id : ");
		String driverId = scanner.nextLine();
		System.out.println("Enter car Id : ");
		String carId = scanner.nextLine();
		System.out.println("Enter driver first name : ");
		String fName = scanner.nextLine();
		String regx = ("[a-z]*");
		if (fName.matches(regx) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter driver second name : ");
		String lName = scanner.nextLine();
		String regx1 = ("[a-z]*");
		if (lName.matches(regx1) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter driver Gender : ");
		String gender = scanner.nextLine();
		String regx2 = ("male|female");
		if (gender.matches(regx2) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter Date of Birth (yyyy-MM-dd) : ");
		String dob = scanner.nextLine();
		// String regx3 =("([0-9]{4}-(0[1-9]|1[0-2])-0[1-9]|1[0-9]|2[0-9]|3[0-1])");
//		String regx3 =("((?:19|20)\\\\d\\\\d)/(0?[1-9]|1[012])/([12][0-9]|3[01]|0?[1-9])");
//		if (dob.matches(regx3)== false) {		
//				System.out.println("invalid input"); 
//			}
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = dateFormat2.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter customer Mobile No: :");
		String num = scanner.nextLine();
		String regx4 = ("[6-9]{1}[1-9]{9}||[+][1][9]//s[6-9]{1}[1-9]{9}");
		if (num.matches(regx4) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Mail Id : ");
		String mail = scanner.nextLine();
		String regx5 = ("\\D*\\d*[@]\\D*[.]\\D{3}");
		if (mail.matches(regx5) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter driver licience : ");
		String licience = scanner.nextLine();

		System.out.println("Enter Available : ");
		String avail = scanner.nextLine();
		String regx6 = ("yes|no");
		if (avail.matches(regx6) == false) {
			System.out.println("invalid input");
		}

		System.out.println("Enter customer Password : ");
		String pass = scanner.nextLine();

		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		Car car = taxiBookingDao.getCar(carId);

		Driver driver = new Driver(driverId, car, fName, lName, gender, date2, num, mail, licience, avail, pass);
//		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.registerDriver(driver);
		System.out.println("");
		System.out.println("******** Registration Successful ***********");
		System.out.println("");
	}

	public void updateDriver() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter driver Id");
		String driverId = scanner.nextLine();
		System.out.println("Enter car Id");
		String carId = scanner.nextLine();
		System.out.println("Enter driver first name : ");
		String fName = scanner.nextLine();
		String regx = ("[a-z]*");
		if (fName.matches(regx) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter driver second name : ");
		String lName = scanner.nextLine();
		String regx1 = ("[a-z]*");
		if (lName.matches(regx1) == false) {
			System.out.println("invalid name");
		}
		System.out.println("Enter driver Gender");
		String gender = scanner.nextLine();
		String regx2 = ("male|female");
		if (gender.matches(regx2) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Date of Birth (yyyy-MM-dd) : ");
		String dob = scanner.nextLine();

		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = dateFormat2.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter customer Mobile No: :");
		String num = scanner.nextLine();
		String regx4 = ("[6-9]{1}[1-9]{9}||[+][1][9]//s[6-9]{1}[1-9]{9}");
		if (num.matches(regx4) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter customer Mail Id : ");
		String mail = scanner.nextLine();
		String regx5 = ("\\D*\\d*[@]\\D*[.]\\D{3}");
		if (mail.matches(regx5) == false) {
			System.out.println("invalid input");
		}
		System.out.println("Enter driver licience : ");
		String licience = scanner.nextLine();

		System.out.println("Enter Available : ");
		String avail = scanner.nextLine();
		String regx6 = ("yes|no");
		if (avail.matches(regx6) == false) {
			System.out.println("invalid input");
		}

		System.out.println("Enter customer Password : ");
		String pass = scanner.nextLine();
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		Car car = taxiBookingDao.getCar(carId);

		Driver driver = new Driver(car, fName, lName, gender, date2, num, mail, licience, avail, pass);
		taxiBookingDao.updateDriver(driver, driverId);
	}

	public void dispDriverDetails() {

		Scanner scanner = new Scanner(System.in);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		List<Driver> driverList = taxiBookingDao.dispDriverDetails();
		System.out.println("  ");
		System.out.println("DriverId" + "   " + "Car Id" + "     " + "FirstName" + "   " + "LastName" + "     "
				+ "CustomerGender" + "   " + "Dob" + "     " + "Mobile_No" + "   " + "Mail Id" + "     "
				+ "Driver Licience" + "    " + "Available" + "   " + "Password");
		System.out.println("  ");
		for (Driver driver : driverList)
			System.out.println(driver.getDriverId() + "  " + driver.getCar().getCarId() + "    " + driver.getFirstName()
					+ "   " + driver.getLastName() + "  " + driver.getGender() + "   " + driver.getDob() + "   "
					+ driver.getMobileNo() + "   " + driver.getMailId() + "    " + driver.getDriverLicience() + "   "
					+ driver.getAvailable() + "    " + driver.getPassword());
		System.out.println("  ");
	}

	public void delDriver(String driverId) {
		Scanner scanner = new Scanner(System.in);
		String driver = driverId;
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.delDriver(driver);
	}

	@Override
	public void driverLogin() {
		// TODO Auto-generated method stub
		char ch;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the DriverId : ");
		String driverId = scanner.nextLine();

		System.out.println("Enter the password : ");
		String pass = scanner.nextLine();

		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		taxiBookingDoa.driverLogin(driverId, pass);

		System.out.println("********************");
		System.out.println(" ");
		do {
			System.out.println(" ");
			System.out.println("1. display details  2. delete   3. Bill Generate   4. Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println(" ");
				driverDisplay(driverId);
				break;
			case 2:
				System.out.println(" ");
				delDriver(driverId);
				break;
			case 3:
				System.out.println(" ");
				System.out.println("Enter Otp NO:");
				int dOtp = scanner.nextInt();
				if (dOtp == otp) {
					genBill();
				} else {
					System.out.println("Bill generated Unsuccessful");
				}
				break;
			case 4:
				break;
			}
			System.out.println(" ");
			System.out.println("Do you want to continue (Y/N) ");
			System.out.println(" ");
			ch = scanner.next().charAt(0);
		} while ((ch == 'y') || (ch == 'Y'));
	}

	public void deleteDriverall() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the DriverId : ");
		String driver = scanner.nextLine();
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.deleteDriverall(driver);
	}

	public void driverDisplay(String driverId) {
		Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter the CustomerId : ");
		// String driverid = scanner.nextLine();
		String driverid = driverId;
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		// taxiBookingDoa.display(customer);
		Driver driver = taxiBookingDoa.driverDisplay(driverid);
		System.out.println(" ");
		System.out.println("DriverId" + "   " + "Car Id" + "     " + "FirstName" + "   " + "LastName" + "     "
				+ "CustomerGender" + "   " + "Dob" + "     " + "mobile_No" + "   " + "mail Id" + "     "
				+ "driver licience" + "  " + "Available" + "   " + "password");
		System.out.println(" ");
		System.out.println(driver.getDriverId() + "  " + driver.getCar().getCarId() + "     " + driver.getFirstName()
				+ "   " + driver.getLastName() + "  " + driver.getGender() + "   " + driver.getDob() + "   "
				+ driver.getMobileNo() + "   " + driver.getMailId() + "    " + driver.getDriverLicience() + "   "
				+ driver.getAvailable() + "     " + driver.getPassword());
		System.out.println(" ");
	}

	// @Override
	public void regCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter car Id : ");
		String carId = scanner.nextLine();
		System.out.println("Enter car no :");
		String carNo = scanner.nextLine();
		System.out.println("Enter Car model name :");
		String carName = scanner.nextLine();
		System.out.println("model description : ");
		String carDesc = scanner.nextLine();
		System.out.println("Enter manufactor year : ");
		String mfgYear = scanner.nextLine();

		Car car = new Car(carId, carNo, carName, carDesc, mfgYear);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.regCar(car);

	}

	public void updateCar() {
		Scanner scanner = new Scanner(System.in);
		Car car2 = new Car();
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		System.out.println("Enter car Id : ");
		carId1 = scanner.nextLine();
		Car car1 = taxiBookingDao.dispCar(carId1);
		dispCar(carId1);
		System.out.println(" ");
		System.out.println("1. Car No: ");
		System.out.println("2. Car Model Name");
		System.out.println("3. Car description");
		System.out.println("4. Manufactor Year");
		System.out.println(" ");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			System.out.println("Enter car no :");
			carNo = scanner.nextLine() + scanner.nextLine();
			break;
		case 2:
			System.out.println("Enter Car model name :");
			carName = scanner.nextLine() + scanner.nextLine();
			break;
		case 3:
			System.out.println("model description : ");
			carDesc = scanner.nextLine() + scanner.nextLine();
			break;
		case 4:
			System.out.println("Enter manufactor year : ");
			mfgYear = scanner.nextLine() + scanner.nextLine();
			break;
		}
		// Car car = new Car(carNo, carName, carDesc, mfgYear);
		car2.setCarNo((carNo != null) ? carNo : car1.getCarNo());
		car2.setModelName((carName != null) ? carName : car1.getModelName());
		car2.setModelDescription((carDesc != null) ? carName : car1.getModelDescription());
		car2.setMfgYear((mfgYear != null) ? mfgYear : car1.getMfgYear());

		taxiBookingDao.updateCar(car2, carId1);
	}

	private List<Car> displayCar() {

		Scanner scanner = new Scanner(System.in);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		List<Car> carList = taxiBookingDao.displayCar();
		System.out.println(" ");
		System.out.println("Car Id" + "    " + "Car no" + "    " + "Car model" + "    " + "model Description" + "     "
				+ "Mfg year");
		System.out.println("  ");
		for (Car car : carList)
			System.out.println(car.getCarId() + "  " + car.getCarNo() + "     " + car.getModelName() + "     "
					+ car.getModelDescription() + "       " + car.getMfgYear());
		System.out.println(" ");
		return carList;
	}

	public void deleteCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Car Id : ");
		String car = scanner.nextLine();
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		taxiBookingDao.deleteCar(car);
	}

	@Override
	public void adminLogin() {
		// TODO Auto-generated method stub
		char ch;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Admin Id : ");
		String adminId = scanner.nextLine();

		System.out.println("Enter the Password : ");
		String pass = scanner.nextLine();

		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		taxiBookingDoa.adminLogin(adminId, pass);

		System.out.println("********************");
		System.out.println(" ");
		do {
			System.out.println(" ");
			System.out.println(
					"1.Register Car  2.Register Driver  3.Display Details  4. update  5. Delete  6. Feedback 7. Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				regCar();
				break;
			case 2:
				registerDriver();
				break;
			case 3:
				do {
					System.out.println("");
					System.out.println("1.Customer   2. Driver   3. Car 4.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1:
						dispCusDetails();
						break;
					case 2:
						dispDriverDetails();
						break;
					case 3:
						displayCar();
						break;
					case 4:
						break;
					}
					System.out.println("Continue Display Details (Y/N) ");
					ch = scanner.next().charAt(0);
				} while ((ch == 'y') || (ch == 'Y'));
				break;
			case 4:
				do {
					System.out.println(" ");
					System.out.println("1. Driver   2. Car  3.Customer  4.Exit");
					int choice2 = scanner.nextInt();
					switch (choice2) {
					case 1:
						updateDriver();
						break;
					case 2:
						updateCar();
						break;
					case 3:
						updateCustomers();
						break;
					case 4:
						break;
					}
					System.out.println("Continue Updating (Y/N) ");
					ch = scanner.next().charAt(0);
				} while ((ch == 'y') || (ch == 'Y'));
				break;
			case 5:
				do {
					System.out.println(" ");
					System.out.println("1.Customer   2. Driver   3. Car 4.Exit");
					int choice3 = scanner.nextInt();
					switch (choice3) {
					case 1:
						deleteCus();
						break;
					case 2:
						deleteDriverall();
						break;
					case 3:
						deleteCar();
						break;
					case 4:
						break;
					}
					System.out.println("Continue Deleting (Y/N) ");
					ch = scanner.next().charAt(0);
				} while ((ch == 'y') || (ch == 'Y'));
				break;
			case 6:
				getReviews();
				break;
			case 7:
				break;
			}
			System.out.println("do you want to continue (Y/N) ");
			ch = scanner.next().charAt(0);
		} while ((ch == 'Y') || (ch == 'y'));

	}

	public void bookTaxi(String customerId) {

		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();

		List<Driver> avail = taxiBookingDao.driverAvail();
		System.out.println(" ");
		System.out.println("Available drivers");
		System.out.println("*****************");
		System.out.println(" ");
		for (Driver driver : avail) {

			System.out
					.println("Driver Id : " + driver.getDriverId() + "    " + "Driver Name : " + driver.getFirstName());
		}
		System.out.println(" ");
		Scanner scanner = new Scanner(System.in);
		String customerid = customerId;

		System.out.println("Enter Driver Id : ");
		driverId = scanner.nextLine();

		System.out.println("Enter starting point : ");
		String sPoint = scanner.nextLine();

		System.out.println("Enter destination");
		String dPoint = scanner.nextLine();

		System.out.println("Enter date : ");
		String date = scanner.nextLine();

		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = dateFormat2.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Enter the Time : ");
		String time = scanner.nextLine();

		System.out.println("Enter distance traveled : ");
		double distance = scanner.nextDouble();
		double price = calculate(distance);

		Driver driver = taxiBookingDao.getDriver(driverId);
		statusDriver(driver); //
		serviceTemp = new Service(driver, sPoint, dPoint, date2, time, distance, price);
		taxiBookingDao.bookTaxi(serviceTemp, customerId);

		System.out.println(" ");
		System.out.println("*********Taxi Booked Successfull**********");
		System.out.println(" ");
	}

	public double calculate(double distance) {
		Scanner scanner = new Scanner(System.in);
		int km = 50;
		double price;

		return price = km * distance;

	}

	public void genBill() {

		Scanner scanner = new Scanner(System.in);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();

		List<Service> serviceList = taxiBookingDao.genBill();
		try {
			Document document = new Document();
			PdfWriter pdfWriter = PdfWriter.getInstance(document,
					new FileOutputStream("D:\\CanddellaTrainingWorkSpace\\Bill.pdf"));
			System.out.println(" ");
			System.out.println("*********** Bill Generated ************");
			System.out.println(" ");
			document.open();
			document.add(new Paragraph("***************************** Taxi Booking **************************"));

			document.add(new Paragraph(" "));
			document.add(new Paragraph("Traval Staring Point : " + serviceTemp.getFrom()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Traval Destination : " + serviceTemp.getTo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Traval Date : " + serviceTemp.getDateRide()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Traval Time : " + serviceTemp.getTimeRide()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("traval Distance Traveled : " + serviceTemp.getDistance() + " km"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Traval Price : " + serviceTemp.getPrice()));

			document.close();
			pdfWriter.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		TaxiBookingDao taxiBookingDoa = new TaxiBookingDaoImpl();
		Driver driver = taxiBookingDoa.driverDisplay(serviceTemp.getDriver().getDriverId());
		statusDriver2(driver);

	}

	public void statusDriver(Driver driver) {

		driver.setAvailable("no");
		new TaxiBookingDaoImpl().updateDriver(driver, driver.getDriverId());
	}

	public void statusDriver2(Driver driver) {

		driver.setAvailable("yes");
		new TaxiBookingDaoImpl().updateDriver(driver, driver.getDriverId());

	}

	private void cusReview(String customerId) {
		// TODO Auto-generated method stub
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		Driver driver = taxiBookingDao.driverDisplay(driverId);
		Customer customer = taxiBookingDao.display(customerId);
		// String driverId = serviceTemp.getDriver().getDriverId();
		Scanner scanner = new Scanner(System.in);
		String cusFname = customer.getFirstName();
		String cusLname = customer.getLastName();
		String driFname = driver.getFirstName();
		String driLname = driver.getLastName();
		System.out.println("1.Very Good  2.Good  3.Bad");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			react = "Very Good";
			break;
		case 2:
			react = "Good";
			break;
		case 3:
			react = "Bad";
			break;
		}
		System.out.println(" ");
		System.out.println("Give Review : ");
		String feedback = scanner.nextLine() + scanner.nextLine();
		Review review = new Review(customer, driver, react, feedback);
		// taxiBookingDao.cusReview(customerId,review,cusFname,cusLname);
		taxiBookingDao.cusReview2(customerId, review, driverId);

	}

	public static List<Review> getReview() {
		Scanner sc = new Scanner(System.in);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		List<Review> reviewList = taxiBookingDao.getReview();
		System.out.println(" ");
		System.out.println(
				"Customer ID" + "  " + "FirstName" + "  " + "LastName" + "   " + "Reaction" + "   " + "Review");
		System.out.println(" ");
		for (Review re : reviewList)
			System.out.println(re.getCustomer().getCustomerId() + "           " + re.getCustomer().getFirstName()
					+ "        " + re.getCustomer().getLastName() + "       " + re.getReview() + "     " + re.getCmt());
		System.out.println(" ");
		return reviewList;
	}

	public static List<Review> getReviews() {
		Scanner sc = new Scanner(System.in);
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		List<Review> reviewList = taxiBookingDao.getReviews();
		System.out.println(" ");
		System.out.println("DriverId" + "    " + "FirstName" + "   " + "LastName" + "  " + "Customer ID" + "    "
				+ "FirstName" + "      " + "LastName" + "    " + "Reaction" + "      " + "Review");
		System.out.println(" ");
		for (Review re : reviewList)
			System.out.println(re.getDriver().getDriverId() + "      " + re.getDriver().getFirstName() + "         "
					+ re.getDriver().getLastName() + "          " + re.getCustomer().getCustomerId() + "             "
					+ re.getCustomer().getFirstName() + "         " + re.getCustomer().getLastName() + "         "
					+ re.getReview() + "       " + re.getCmt());
		System.out.println(" ");
		return reviewList;
	}

	public void dispCar(String carId1) {
		TaxiBookingDao taxiBookingDao = new TaxiBookingDaoImpl();
		Car car = taxiBookingDao.dispCar(carId1);
		System.out.println(" ");
		System.out.println("Car Id" + "    " + "Car no" + "    " + "Car model" + "    " + "model Description" + "     "
				+ "Mfg year");
		System.out.println("  ");
		System.out.println(car.getCarId() + "   " + car.getCarNo() + "     " + car.getModelName() + "        "
				+ car.getModelDescription() + "         " + car.getMfgYear());
		System.out.println(" ");
	}

	public void payment() {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("");
		System.out.println("Offline Payment");
		System.out.println("Price  : " + serviceTemp.getPrice());
		System.out.println(" ");
		otp = rand.nextInt(10000, 20000);
		System.out.println("Otp No : " + otp);
		System.out.println("");
	}

}