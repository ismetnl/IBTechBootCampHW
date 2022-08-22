package com.hw.test;

import java.util.ArrayList;
import java.util.List;

import com.hw.bean.Supplier;

public class TestFind {
	
	private static Supplier supplierFind(List<Supplier> supplierList,long supplierId) {
		for(Supplier supplier: supplierList) {
			if(supplier.getSupplierId() == supplierId) {
				return supplier;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			List<Supplier> supplierList = new ArrayList<>();
			supplierList.add(new Supplier(601, "Cem Karaca", 6540));
			supplierList.add(new Supplier(602, "Barış Manço", 6541));
			supplierList.add(new Supplier(603, "Fikret kızılok", 6542));
			long supplierId = 604;
			Supplier supplier = supplierFind(supplierList, supplierId);
			
			if(supplier != null) {
				System.out.println(supplier.getSupplierId()+" "
						+supplier.getSupplierName()+" "
						+supplier.getTotalCredit());
			}
			else {
				System.out.println("Satımcı bulunamadı: "+supplierId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
