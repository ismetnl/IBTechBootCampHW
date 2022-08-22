package com.hw.sales;

public class CustomerTest2 {
	public static void main(String[] args) {
		Customer customer = new Customer(501,"Neşet Ertaş",4350);
		
		System.out.println("Müşteri Özdeşliği: "+customer.getCustomerId());
		System.out.println("Müşteri Adı-Soyadı: "+customer.getCustomerName());
		System.out.println("Müşteri Borcu: "+customer.getTotalDebit());
		
	}
}
