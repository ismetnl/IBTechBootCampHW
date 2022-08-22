package com.hw.pattern;

import java.util.List;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestList {
	public static void main(String[] args) throws Exception {
		CustomerManager customerManager = new CustomerManager();
		List<Customer> customers = customerManager.list();
		
		for(Customer customer : customers) {
			System.out.println(customer.getCustomerId()+" "
					+customer.getCustomerName()+" "
					+customer.getTotalDebit());
		}
	}
}
