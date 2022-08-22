package com.hw.accountparser;

public class AccountConverterTest {
	public static void main(String[] args) {
		String line="601;Kasa Hesabı;23560";
		
		Account account;
		AccountConverter converter = new AccountConverter();
		account=converter.parse(line);
		System.out.println(account.getAccountId()+";"+account.getAccountName()+";"+account.getAmountLocal());
		
		String string=converter.format(account);
		System.out.println(string);
	}
}
