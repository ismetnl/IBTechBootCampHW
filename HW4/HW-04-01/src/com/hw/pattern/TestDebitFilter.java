package com.hw.pattern;

import java.util.List;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestDebitFilter {
	
	public static void main(String[] args) throws Exception {
		
		CustomerManager customerManager = new CustomerManager();
		double totalDebitMin= 5000;
		List<Customer> customers = customerManager.listByTotalDebitGrater(totalDebitMin);
		
		for(Customer customer : customers) {
			System.out.println(customer.getCustomerId()+" "
					+customer.getCustomerName()+" "
					+customer.getTotalDebit());
		}
	
	}
}
