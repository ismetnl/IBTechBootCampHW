package com.hw.transaction.client;

import static com.hw.transaction.utils.StreamUtilities.*;

import com.hw.transaction.converter.TransactionConverter;
import com.hw.transaction.entity.Transaction;


public class TransactionClient {
	public static void main(String[] args) throws Exception {
		String adress = "http://localhost:8080/HW-05-03/Transaction";
		String line = get(adress);
		
		TransactionConverter converter = new TransactionConverter();
		Transaction transaction = converter.parse(line);
		
		System.out.println(transaction.getTransactionId()+" "
				+transaction.getTransactionName()+" "
				+transaction.getAmountLocal());
	}
}
