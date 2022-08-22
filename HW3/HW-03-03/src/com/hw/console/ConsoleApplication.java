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
	private static Thread thread;

	private static void handleChoice(int choice) throws IOException {
		
		if(choice != 1 && suppliers == null) {
			System.out.println("İlk önce yükleme yapın");
			return;
		}
		
		switch (choice) {

		case 1:

			Runnable runnableLoad = new Runnable() {

				@Override
				public void run() {
					try {
						doLoad();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			runThread(runnableLoad);

			break;

		case 2:
			Runnable runnableStore = new Runnable() {

				@Override
				public void run() {
					try {
						doStore();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			runThread(runnableStore);
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
			System.out.println("Geçersiz seçim :" + choice);
			break;
		}
	}

	private static void runThread(Runnable runnable) {
		thread = new Thread(runnable);
		thread.start();
	}

	private static void doLoad() throws IOException {
		try {
			suppliers = new ArrayList<Supplier>();
			
			String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaBootCamp\\JavaIO\\Supplier.txt";
			SupplierFiller supplierFiller = new SupplierFiller(filepath);
			suppliers = supplierFiller.load();
			System.out.println("Yükleme yapılıyor");

			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void doStore() throws IOException {

		try {
			String filepath = "C:\\Users\\ISMETUNLU\\Desktop\\JavaBootCamp\\JavaIO\\Supplier.txt";
			SupplierFiller supplierFiller = new SupplierFiller(filepath);

			
			supplierFiller.store(suppliers);
			System.out.println("Yazdırma yapılıyor");
		
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void doList() {
		
		for (Supplier supplier : suppliers) {
			printSuplier(supplier);
		}
	
	}

	private static void doFind() {
		
		int supplierId = findSuplier();
		if (supplierId != -1) {
			printSuplier(suppliers.get(supplierId));
		} else {
			System.out.println("Girilen id deki supplier bulunamadı");
		}
		
	}

	private static void doAdd() {
		
		Supplier supplier = enterSuplier();
		suppliers.add(supplier);
		doList();
	
	}

	private static void doUpdate() {
		

		int supplierId = findSuplier();
		if (supplierId != -1) {
			Supplier supplier = enterSuplier();
			suppliers.set(supplierId, supplier);
			doList();
		} else {
			System.out.println("Girilen id deki supplier bulunamadı");
		}

		
	}

	private static void doDelete() {
		
		try {

			int supplierId = findSuplier();
			if (supplierId != -1) {
				suppliers.remove(supplierId);
				doList();
			} else {
				System.out.println("Girilen id deki supplier bulunamadı");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void doExit() {
		System.out.println("Sistemden çıkış yapılıyor");
		System.exit(0);
	}

	private static int findSuplier() {

		System.out.println("Suplier ID Giriniz: ");
		int supplierId = scanner.nextInt();

		for (int index = 0; index < suppliers.size(); index++) {
			if (suppliers.get(index).getSupplierId() == supplierId) {
				return index;
			}

		}
		return -1;
	}

	private static void printSuplier(Supplier supplier) {
		System.out
				.println(supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
	}

	private static Supplier enterSuplier() {

		System.out.println("Suplier ID Giriniz: ");
		long supplierId = scanner.nextLong();

		for (Supplier supplier : suppliers) {
			if (supplier.getSupplierId() == supplierId) {
				System.out.println("Girilen id alınmış, Lütfen yeni bir id giriniz !!");
				return enterSuplier();
			}
		}

		System.out.println("Suplier ismini Giriniz: ");
		String supplierName = scanner.next();
		System.out.println("Toplam kerdiyi Giriniz: ");
		double TotalCredit = scanner.nextDouble();

		return new Supplier(supplierId, supplierName, TotalCredit);
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
