package com.code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {
	public static List<Customer> populateCustomerList() {
		/*
		 * String firstName, String lastName, String email, String password, double
		 * regAmount, LocalDate dob, ServicePlan plan
		 */
		List<Customer> customers = new ArrayList<>();
		/*String fname, String lname, String email, String password, double registrationAmount, 
		 * LocalDate dob,ServicePlan plan,LocalDate lastSubscriptionPaidDate*/
		customers.add(new Customer("Rama", "Kadam", "rama@gmail.com", "rama#123", 2000, LocalDate.parse("1990-01-01"),
				ServicePlan.GOLD,LocalDate.parse("2023-08-20")));
		customers.add(new Customer("Kiran", "Khare", "kiran@gmail.com", "kiran#123", 1000, LocalDate.parse("1995-01-01"),
				ServicePlan.SILVER,LocalDate.parse("2023-10-25")));
		customers.add(new Customer("Mihir", "Mujumdar", "mihir@gmail.com", "mih#123", 2000, LocalDate.parse("1993-11-21"),
				ServicePlan.GOLD,LocalDate.parse("2023-10-01")));
		customers.add(new Customer("Rakesh", "Malik", "rakesh@gmail.com", "rak#123", 2000, LocalDate.parse("1994-09-21"),
				ServicePlan.GOLD,LocalDate.parse("2023-07-13")));
		customers.add(new Customer("Riya", "Pathak", "riya@gmail.com", "riy#123", 5000, LocalDate.parse("1996-12-31"),
				ServicePlan.DIAMOND,LocalDate.parse("2022-10-19")));
		return customers;
	}
}


















