package com.hw.test;

import java.util.List;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestNameFilter {
	public static void main(String[] args) throws Exception {
		CustomerManager customerManager = new CustomerManager();
		String Filter= "met";
		List<Customer> customers = customerManager.listByNameLikeFilter(Filter);
		
		for(Customer customer : customers) {
			System.out.println(customer.getCustomerId()+" "
					+customer.getCustomerName()+" "
					+customer.getTotalDebit());
		}
	
	}
}
