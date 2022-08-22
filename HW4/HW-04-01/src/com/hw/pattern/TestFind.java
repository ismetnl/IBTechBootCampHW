package com.hw.pattern;

import com.hw.entity.Customer;
import com.hw.manager.CustomerManager;

public class TestFind {
	public static void main(String[] args) {
		try {
			CustomerManager customerManager = new CustomerManager();
			Customer customer  = customerManager.find(1);
			if(customer != null) {
				System.out.println(customer.getCustomerId()+ " "
						+customer.getCustomerName()+ " "
						+customer.getTotalDebit());
			}
			else {
				System.out.println("Ürün Bulunamadı");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
