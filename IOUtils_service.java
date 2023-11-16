package utils;

import java.util.*;
import java.io.*;

import com.code.Customer;

public class IOUtils_service {
	public static void storeCustomerDetails(List<Customer> custL, String fileName)throws IOException{
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			custL.stream()
			.forEach(p -> pw.println(p));
		}
	}
}
