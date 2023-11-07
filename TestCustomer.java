package com.test;

import static com.code.CustomerUtils.populateCustomerList;
import static custom_exception.ValidationRules.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.code.Customer;
import com.code.ServicePlan;

import custom_ordering.CustomerDobComparator;

public class TestCustomer {
	public static void main(String[] args) {
		//try with resources---can exists on its own
		try (Scanner sc=new Scanner(System.in)){
			//initialization
			//get the populated ArrayList from utils
			List<Customer> customerList=populateCustomerList();
			boolean exit=false;
			while(!exit) {
				System.out.println();
				System.out.println("Options: ");
				System.out.println("1.Sign Up\n"+"2.Sign In\n"+"3.Display all\n"+"4.Change Password\n"
						+ "5.Un subscribe\n"+"6.Sort based on email\n"+"7.Sort based on DOB\n"+
						"8.Sort based on DOB & NAME\n"+"9.Subscription not paid for 3 months\n"+"10.Subscription not paid for 6 months\n"+"0. Exit");
					try {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("Available plans and their registration amount: "+"SILVER---1000\n"+"GOLD---2000\n"+"DIAMOND---5000\n"+"PLATINUM---10000\n");
							System.out.println("Enter customer details: fname lname email password registrationAmount dob(yyyy-mm-dd) plan lastSubscriptionPaidDate");
							/*
							 * firstName, String lastName, String email, String password, double regAmount,
							 * String dob, String plan
							 */
							Customer newCust = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
									sc.nextDouble(), sc.next(), sc.next(),sc.next(), customerList);
							customerList.add(newCust);
							System.out.println("Customer Signed Up successfully!!\n"+"Account Created...");
							System.out.println(newCust);
							break;
							
						case 2:
							System.out.println("Enter email n password for sign in");
							newCust = authenticateCustomer(sc.next(),sc.next(),customerList);
							System.out.println("Succesful Login , your details : "+newCust);
							break;
						
						case 3: //disply all 
								for(Customer c: customerList)
									System.out.println(c);
								break;
								
						case 4: //change password
								System.out.println("Enter email and password to authenticate");
								newCust = authenticateCustomer(sc.next(), sc.next(), customerList);
								System.out.println("Succesful Login , your details : "+newCust);
								System.out.println("Enter new password");
								String pwd=sc.next();
								newCust.setPassword(pwd);
								System.out.println("Password changed successfully!!");
								break;
								
						case 5:
								System.out.println("Enter email and password to unsubscribe");
								newCust = authenticateCustomer(sc.next(), sc.next(), customerList);
								customerList.remove(validateIndex(newCust.getEmail(),customerList));
								System.out.println("Successfully unsubscribed");
								break;
								
						case 6:
							//Sort customer details as per email , using Natural Ordering
							Collections.sort(customerList);
							System.out.println("---------------Sorted details based on email---------------");
							for(Customer li:customerList)
								System.out.println(li);
							System.out.println("------------------------------------------------------------");
							break;
								
						case 7://Sort customer details as per date of birth , using custom ordering
							Collections.sort(customerList,new CustomerDobComparator());
							System.out.println("---------------Sorted details based on DOB---------------");
							for(Customer li:customerList)
								System.out.println(li);
							System.out.println("------------------------------------------------------------");
							break;
							
						case 8:
							//Sort customer details as per date of birth n last name , 
							//using custom ordering n anonymous inner class
							Collections.sort(customerList,new CustomerDobComparator());
							System.out.println("---------------Sorted details based on DOB & NAME---------------");
							for(Customer li:customerList)
								System.out.println(li);
							System.out.println("------------------------------------------------------------");
							break;
							
						case 9://find out the complete names of the customers, 
							//who have not paid the subscription (reg amount),for last 3 months
							Iterator<Customer> itr=customerList.iterator();
							List<Customer> cls = new ArrayList<>();
							while(itr.hasNext())
							{
							Customer c=itr.next();
							long months=Period.between(c.getLastSubscriptionPaidDate(),LocalDate.now()).toTotalMonths();
							if(months>3) {
								cls.add(c);
								}
							}
							System.out.println();
							System.out.println("---------------------Accounts that have not paid the subscription amount from last 3 months: ------------------");
							for(Customer i:cls) {
								System.out.println(i);
							}
							break;
							
						case 10://remove all those customer details 
							//whose subscription is pending for last 6 months
							Iterator<Customer> itr1=customerList.iterator();
							List<Customer> cls1 = new ArrayList<>();
							while(itr1.hasNext())
							{
							Customer c=itr1.next();
							long months=Period.between(c.getLastSubscriptionPaidDate(),LocalDate.now()).toTotalMonths();
							if(months>6) {
								cls1.add(c);
								itr1.remove();
								}
							}
							System.out.println();
							System.out.println("------------------Above accounts are closed by admin as they have not paid the subscription amount from last 6 months!!-------------");
							for(Customer i:cls1) {
								System.out.println(i);
								}
							break;
							
						case 0:
							exit = true;
							break;
						}
					} catch (Exception e) {
						// to read off the pending i/ps from scanner
						sc.nextLine();
						System.out.println(e);
				}
			}
		}
	}
}

						