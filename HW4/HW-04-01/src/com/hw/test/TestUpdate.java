package com.hw.test;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestUpdate {
	public static void main(String[] args) {
		
		try {
			CustomerManager customerManager = new CustomerManager();
			Customer customer = new Customer(1,"ismet ünlü",19000);
			boolean updated = customerManager.update(customer);
			
			if(updated) {
				System.out.println("Ürün güncellendi");
			}
			else {
				System.out.println("Ürün güncellenemedi");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
