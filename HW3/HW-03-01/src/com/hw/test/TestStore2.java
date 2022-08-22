package com.hw.test;

import java.util.ArrayList;
import java.util.List;

import com.hw.bean.Customer;
import com.hw.filer.CustomerFiller;

public class TestStore2 {
	public static void main(String[] args) {
		try {
			List<Customer> customers = new ArrayList<>();
			customers.add(new Customer(601, "Cem Karaca", 6540));
			customers.add(new Customer(602, "Barış Manço", 6541));
			customers.add(new Customer(603, "Fikret kızılok", 6542));
			
			String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaBootCamp\\JavaIO\\Customer.txt";
			CustomerFiller customerFiller = new CustomerFiller(filepath);
			customerFiller.store(customers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
