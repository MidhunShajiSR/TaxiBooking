package com.candella.utility;
import java.util.Scanner;
import com.candella.service.TaxiBookingServiceDao;
import com.candella.service.TaxiBookingServiceDaoImpl;
public class TaxingBookingUtility {
	public static void main(String[] args) {
		char ch;
		Scanner scanner = new Scanner(System.in);
		TaxiBookingServiceDao taxiBookingServiceDao = new TaxiBookingServiceDaoImpl();
		do {
			System.out.println("1.Admin  2.Customer  3.Driver");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				taxiBookingServiceDao.adminLogin();
				break;
			case 2:
				do {
					System.out.println("1.login 2.Signin 3.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1:
						taxiBookingServiceDao.logins();
						break;
					case 2:
						taxiBookingServiceDao.createAccount();
						break;
					case 3:
						break;
					}
					System.out.println("Go to Customer Login & Signin Menu (Y/N) ");
					ch = scanner.next().charAt(0);
				} while ((ch == 'y') || (ch == 'Y'));
				break;
			case 3:
				taxiBookingServiceDao.driverLogin();
				break;
			}
			System.out.println("Go to main (Y/N)");
			ch = scanner.next().charAt(0);
		} while ((ch == 'y') || (ch == 'Y'));
	}
}