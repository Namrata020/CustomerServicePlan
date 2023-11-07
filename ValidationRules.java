package custom_exception;

import java.time.LocalDate;
import java.util.List;

import com.code.Customer;
import com.code.ServicePlan;

public class ValidationRules {
	// add a method to check for duplicate customer entry
	public static void checkForDuplicate(String email, List<Customer> customers) throws DuplicateCustomerException {
		Customer newCust = new Customer(email);
		if (customers.contains(newCust))
			throw new DuplicateCustomerException("Customer already exists!!!");
	}

	// add a method to validate registration amount with the plan
	public static void validatePlanAmount(ServicePlan plan, double registrationAmount) throws AmountMismatchException {
		if (plan.getPlanCost() != registrationAmount)
			throw new AmountMismatchException("Registration amount doesn't match ");
	}

	// add a method to validate service plan
	public static ServicePlan ValidatePlan(String plan) throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	// add method to check email
	/*
	 * 1 well formed email: [a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net) String: public
	 * boolean matches(String regEx) 2 no duplicate
	 */
	public static void validateEmail(String email, List<Customer> customerList) throws InvalidInputException {
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(pattern))
			throw new InvalidInputException("Invalid email");
	}

	// parse date from string format
	private static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	// add a method for customer authentication
	public static Customer authenticateCustomer(String email, String pass, List<Customer> customers)
			throws InvalidInputException {
		// chk if customer exists by email
		int index = customers.indexOf(new Customer(email));
		if (index == -1)
			throw new InvalidInputException("Login failed : email invalid");
		// => email valid , get customer details
		Customer c = customers.get(index);
		// chk password
		if (!c.getPassword().equals(pass))
			throw new InvalidInputException("Login failed : password invalid");
		return c;
	}

	// add a method to validate index
	public static Customer validateIndex(String email, List<Customer> customers) throws InvalidInputException {
		// chk if customer exists by email
		int index = customers.indexOf(new Customer(email));
		if (index == -1)
			throw new InvalidInputException("Login failed : email invalid");
		// => email valid , get customer details
		Customer c = customers.get(index);

		return c;
	}

	// add a method to call validation rules
	public static Customer validateAllInputs(String fname, String lname, String email, String password,
			double registrationAmount, String dob, String plan,String lastSubscriptionPaidDate, List<Customer> customers)
			throws DuplicateCustomerException, AmountMismatchException, IllegalArgumentException, InvalidInputException {
		validateEmail(email,customers);
		ServicePlan pln = ValidatePlan(plan);
		validatePlanAmount(pln, registrationAmount);
		LocalDate date =parseDate(dob);
		checkForDuplicate(email, customers);
		LocalDate dt=parseDate(lastSubscriptionPaidDate);
		// All validations rules are cleared
		return new Customer(fname, lname, email, password, registrationAmount, date, pln,dt);
	}	
}
