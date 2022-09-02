package com.hw.transaction.converter;

import com.hw.transaction.entity.Transaction;

public class TransactionConverter {
	
	public TransactionConverter() {
		
	}
	
	public Transaction parse(String line) {
		
		Transaction transaction = new Transaction();
		String[] Data = line.split(";");
		transaction.setTransactionId(Long.parseLong(Data[0]));
		transaction.setTransactionName(Data[1]);
		transaction.setAmountLocal(Double.parseDouble(Data[2]));

		return transaction;
	}
	public String format(Transaction transaction) {
		
		String line;
		StringBuilder builder = new StringBuilder();
		
		builder.append(transaction.getTransactionId()).append(";")
			   .append(transaction.getTransactionName()).append(";")
			   .append(transaction.getAmountLocal()).append(";");
		
		line = builder.toString();
		
	    return line;
	}
}
