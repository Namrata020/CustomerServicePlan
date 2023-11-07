package com.code;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	private int id;
	private String fname,lname,email,password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate lastSubscriptionPaidDate;
	
	//static id generator
	private static int idGenerator;
	static {
		idGenerator=1;
	}
	
	public Customer(String fname, String lname, String email, String password, double registrationAmount, LocalDate dob,
			ServicePlan plan,LocalDate lastSubscriptionPaidDate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
		this.id=idGenerator++;
	}

	public Customer(String email) {
		super();
		this.email=email;
	}
	
//	public Customer(LocalDate lastSubscriptionPaidDate) {
//		super();
//		this.lastSubscriptionPaidDate=LocalDate.now();
//	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", registrationAmount=" + registrationAmount + ", dob=" + dob/*formatted date(yy-mm-dd)*/ + ", plan=" + plan + "]";
	}

	@Override
	public boolean equals(Object anotherObj)
	{
		//System.out.println("in customer equals");
		if(anotherObj instanceof Customer)
			return this.email.contentEquals(((Customer) anotherObj).email);
		return false;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public ServicePlan getPlan() {
		return plan;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		//System.out.println("Overriden compareTo");
		return this.email.compareTo(anotherCustomer.email);
	}
}
