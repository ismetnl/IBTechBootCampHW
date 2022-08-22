package com.hw.pattern;

import com.hw.manager.CustomerManager;

public class TestDelete {
	public static void main(String[] args) {
		
		try {
			CustomerManager customerManager = new CustomerManager();
			boolean updated = customerManager.delete(5);
			
			if(updated) {
				System.out.println("Ürün silindi");
			}
			else {
				System.out.println("Ürün silinemedi");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
