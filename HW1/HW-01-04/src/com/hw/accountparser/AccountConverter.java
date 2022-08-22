package com.hw.accountparser;

public class AccountConverter {
	public Account parse(String line) {
		
		Account account = new Account();
		String[] token = line.split(";");
		account.setAccountId(Long.parseLong(token[0]));
		account.setAccountName(token[1]);
		account.setAmountLocal(Double.parseDouble(token[2]));
		
		return account;
	}
	public String format(Account account) {
		
		String string = new StringBuilder(account.getAccountId()+";")
				.append(account.getAccountName()+";")
				.append(account.getAmountLocal())
				.toString();
		
		return string;
	}
}
