package com.hw.transaction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.transaction.converter.TransactionConverter;
import com.hw.transaction.entity.Transaction;


@WebServlet("/Transaction")
public class TransactionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public TransactionServlet() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text; charset = UTF-8");
		PrintWriter out = response.getWriter();
		TransactionConverter converter = new TransactionConverter();
		Transaction transaction = new Transaction(501,"Elektrik Ödemesi",5460);
		
		String line = converter.format(transaction);
		out.println(line);
		
	}



}
