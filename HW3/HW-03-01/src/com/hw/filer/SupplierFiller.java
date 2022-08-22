package com.hw.filer;

import com.hw.bean.Supplier;

public class SupplierFiller extends BaseFiler<Supplier>{
	
	
	public SupplierFiller(String filepath) {
		super(filepath);
	}
	
	protected String format(Supplier supplier) {
		StringBuilder builder = new StringBuilder();
		builder.append(supplier.getSupplierId()).append(DELIMETER);
		builder.append(supplier.getSupplierName()).append(DELIMETER);
		builder.append(supplier.getTotalCredit());
		return builder.toString();
		
		
	}


	protected Supplier parse(String line) {
		String[] token = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Long.parseLong(token[0]));
		supplier.setSupplierName(token[1]);
		supplier.setTotalCredit(Double.parseDouble(token[2]));
		return supplier;
		
		
	}
	

	
	
}
