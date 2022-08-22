package com.hw.filer;

import com.hw.bean.Customer;

public class CustomerFiller extends BaseFiler<Customer>{
	
	public CustomerFiller(String filepath) {
		super(filepath);
	}
	
	protected String format(Customer customer) {
		StringBuilder builder = new StringBuilder();
		builder.append(customer.getCustomerId()).append(DELIMETER);
		builder.append(customer.getCustomerName()).append(DELIMETER);
		builder.append(customer.getTotalDebit());
		return builder.toString();
		
		
	}


	protected Customer parse(String line) {
		String[] token = line.split(DELIMETER);
		Customer customer = new Customer();
		customer.setCustomerId(Long.parseLong(token[0]));
		customer.setCustomerName(token[1]);
		customer.setTotalDebit(Double.parseDouble(token[2]));
		return customer;
		
		
	}
}
