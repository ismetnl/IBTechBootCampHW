package com.hw.test;

import java.io.IOException;
import java.util.List;

import com.hw.bean.Customer;
import com.hw.filer.CustomerFiller;

public class TestLoad2 {
	public static void main(String[] args) throws IOException{
		String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaIO\\Customer.txt";
		CustomerFiller customerFiller = new CustomerFiller(filepath);
		List<Customer> customers =customerFiller.load();
		
		for(Customer customer : customers) {
			System.out.println(customer.getCustomerId()+" "
					+customer.getCustomerName()+" "
					+customer.getTotalDebit());
		
		}
	}
}
