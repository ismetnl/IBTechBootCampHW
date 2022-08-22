package com.hw.accountscan;

import java.util.Scanner;


public class AccountTest {
	public static void main(String[] args) {
		
		Account account = new Account();
		AccountConverter converter = new AccountConverter();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Account Id: ");
		account.setAccountId(scanner.nextLong());
		System.out.println("Account Name:");
		account.setAccountName(scanner.next());
		
		System.out.println("Account Amount:");
		account.setAmountLocal(scanner.nextDouble());
		scanner.close();
		
		String string=converter.format(account);
		System.out.println(string);
		
		//System.out.printf("Account Id: %d;Account Name: %s;Account Amount: %100.2f",account.getAccountId(),account.getAccountName(),account.getAmountLocal());

	}
}
