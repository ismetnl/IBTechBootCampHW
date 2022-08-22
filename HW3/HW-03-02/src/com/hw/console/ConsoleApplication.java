package com.hw.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw.bean.Supplier;
import com.hw.filer.SupplierFiller;

public class ConsoleApplication {
	
	private static Scanner scanner = new Scanner(System.in);
	private static List<Supplier> suppliers = null;
	
	private static void handleChoice(int choice) throws IOException {
		switch (choice) {
		
		case 1:
			doLoad();
			break;
		
		case 2:
			doStore();
			break;
		
		case 3:
			doList();
			break;
		
		case 4:
			doFind();
			break;
		
		case 5:
			doAdd();
			break;
		
		case 6:
			doUpdate();
			break;
		
		case 7:
			doDelete();
			break;
		case 0:
			doExit();
			break;
			
		default:
			System.out.println("Geçersiz seçim :"+choice);
			break;
		}
	}
	
	
	private static void doLoad() throws IOException {
		suppliers = new ArrayList<Supplier>();
		
		String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaBootCamp\\JavaIO\\Supplier.txt";
		SupplierFiller supplierFiller = new SupplierFiller(filepath);
		suppliers = supplierFiller.load();
		System.out.println("Yükleme yapıldı");
		
	}
	
	private static void doStore() throws IOException{
		String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaBootCamp\\JavaIO\\Supplier.txt";
		SupplierFiller supplierFiller = new SupplierFiller(filepath);
		
		if(suppliers != null) {
			supplierFiller.store(suppliers);
			System.out.println("Yazdırma yapıldı");
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	
	private static void doList() {
		if(suppliers != null) {
			for(Supplier supplier : suppliers) {
				printSuplier(supplier);
			}
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	
	private static void doFind() {
		if(suppliers != null) {
			int supplierId = findSuplier();
			if(supplierId != -1) {
				printSuplier(suppliers.get(supplierId));
			}
			else {
				System.out.println("Girilen id deki supplier bulunamadı");
			}
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	
	private static void doAdd() {
		if(suppliers != null) {
			Supplier supplier = enterSuplier();
			suppliers.add(supplier);
			doList();
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	
	private static void doUpdate() {
		if(suppliers != null) {
			
			int supplierId = findSuplier();
			if(supplierId != -1) {
				Supplier supplier = enterSuplier();
				suppliers.set(supplierId, supplier);
				doList();
			}
			else {
				System.out.println("Girilen id deki supplier bulunamadı");
			}
			
			
				
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	
	private static void doDelete() {
		if(suppliers != null) {
			try {
				
				int supplierId = findSuplier();
				if(supplierId != -1) {
					suppliers.remove(supplierId);
					doList();
				}
				else {
					System.out.println("Girilen id deki supplier bulunamadı");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("İlk önce yükleme yapın");
		}
	}
	private static void doExit() {
		System.out.println("Sistemden çıkış yapılıyor");
		System.exit(0);
	}
	
	private static int findSuplier() {
		
		System.out.println("Suplier ID Giriniz: ");
		int supplierId = scanner.nextInt();
		
		
		for(int index = 0; index < suppliers.size() ; index++) {
			if(suppliers.get(index).getSupplierId() == supplierId) {
				return index;
			}
		
		}
		return -1;
	}
	
	private static void printSuplier(Supplier supplier) {
		System.out.println(supplier.getSupplierId()+" "
				+supplier.getSupplierName()+" "
				+supplier.getTotalCredit());
	}
	
	
	private static Supplier enterSuplier() {
		
		System.out.println("Suplier ID Giriniz: ");
		long supplierId = scanner.nextLong();
		
		for(Supplier supplier : suppliers) {
			if(supplier.getSupplierId() == supplierId) {
				System.out.println("Girilen id alınmış, Lütfen yeni bir id giriniz !!");
				return enterSuplier();
			}
		}
		
		
		System.out.println("Suplier ismini Giriniz: ");
		String supplierName = scanner.next();
		System.out.println("Toplam kerdiyi Giriniz: ");
		double TotalCredit = scanner.nextDouble();
				
		return new Supplier(supplierId,supplierName,TotalCredit);
	}
	
	private static void printMenu() {
		System.out.println("Menu: ");
		System.out.println("1. Yükle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Bul");
		System.out.println("5. Ekle");
		System.out.println("6. Güncelle");
		System.out.println("7. Sil");
		System.out.println("0. Çık");
 		System.out.println("Şeçiminiz: ");
	}
	
	
	public static void main(String[] args) {
		
		
		while (true) {
			
			printMenu();
			int choice = scanner.nextInt();
			try {
				handleChoice(choice);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
