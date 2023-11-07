package custom_ordering;

import java.util.Comparator;

import com.code.Customer;

public class CustomerDobComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		if(c1.getDob().equals(c2.getDob()))
			return c1.getFname().compareTo(c2.getLname());
		if(c1.getDob().isBefore(c2.getDob()))
			return -1;
		return 1;
	}

}
