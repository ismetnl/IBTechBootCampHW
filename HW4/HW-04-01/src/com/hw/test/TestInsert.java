package com.hw.test;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestInsert {

	public static void main(String[] args) {
		
		try {
			CustomerManager customerManager = new CustomerManager();
			Customer customer = new Customer(1,"ismet ünlü",5000);
			boolean inserted = customerManager.insert(customer);
			
			if(inserted) {
				System.out.println("Ürün sokuldu");
			}
			else {
				System.out.println("Ürün sokulamadı");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
