package com.hw.test;

import java.io.IOException;
import java.util.List;

import com.hw.bean.Supplier;
import com.hw.filer.SupplierFiller;

public class TestLoad {
	public static void main(String[] args) throws IOException{
		String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaIO\\Supplier.txt";
		SupplierFiller supplierFiller = new SupplierFiller(filepath);
		List<Supplier> suppliers =supplierFiller.load();
		
		for(Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierId()+" "
					+supplier.getSupplierName()+" "
					+supplier.getTotalCredit());
		
		}
	}
}
