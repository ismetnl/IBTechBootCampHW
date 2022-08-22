package com.hw.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hw.entity.Customer;

public class CustomerManager {
	
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "209152Ok";
	private String driver = "org.postgresql.Driver";
	
	
	public CustomerManager() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Customer find(long customerId) throws Exception{
		Customer customer = null;
		

		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="select * from customer where customerid = ?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setDouble(1, customerId);
		ResultSet resultSet = statement.executeQuery();
		
		
		if(resultSet.next()) {
			customer = parse(resultSet);
			return customer;
		}
		
		connection.close();
		return customer;
		
	}

	
	
	public List<Customer> list() throws Exception{
		
		List<Customer> customers = new ArrayList<>();
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="select * from customer";
		PreparedStatement statement =  connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		customers = parseList(customers, resultSet);
		
		
		connection.close();
		
		
		return customers;
	}
	
	
	
	public List<Customer> listByTotalDebitGrater(double salesPriceMin) throws Exception{
		
		List<Customer> customers = new ArrayList<>();
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="select * from customer where totalDebit > ?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setDouble(1, salesPriceMin);
		ResultSet resultSet = statement.executeQuery();
		
		customers = parseList(customers, resultSet);
		
		
		connection.close();
		
		
		return customers;
	}
	
	public List<Customer> listByNameLikeFilter(String Filter) throws Exception{
		
		List<Customer> customers = new ArrayList<>();
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="select * from customer where customerName like ?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setString(1, "%"+Filter+"%");
		ResultSet resultSet = statement.executeQuery();
		
		customers = parseList(customers, resultSet);
		
		
		connection.close();
		
		
		return customers;
	}
	
	private Customer parse(ResultSet resultSet) throws SQLException {
		Customer customer;
		long customerid = resultSet.getLong("customerid");
		String customerName = resultSet.getString("customerName");
		double totalDebit = resultSet.getDouble("totalDebit");
		
		customer = new Customer(customerid,customerName,totalDebit);
		return customer;
	}
	
	private List<Customer> parseList(List<Customer> customers, ResultSet resultSet) throws SQLException {
		
		while(resultSet.next()) {
			
			Customer customer = parse(resultSet);
			customers.add(customer);
		}
		return customers;
		
	}
	
	public boolean delete(long customerId) throws Exception{
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="delete from customer where customerId=?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setDouble(1, customerId);
		int affected = statement.executeUpdate();
		
		connection.close();
		
		System.out.println("Etkilenmiş "+affected);
		
		return affected>0;
	}
	
	public boolean update(Customer customer) throws Exception{
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="update customer set customerName=?, totalDebit=? where customerId=?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		statement.setDouble(3, customer.getCustomerId());
		int affected = statement.executeUpdate();
		
		connection.close();
		
		System.out.println("Etkilenmiş "+affected);
		return affected>0;
	}


	public boolean insert(Customer customer) throws Exception{
	
		Class.forName(driver);
		
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql ="insert into customer(customername,totalDebit) values (?,?)";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		
		int affected = statement.executeUpdate();
		
		connection.close();
		
		System.out.println("Etkilenmiş "+affected);
		return affected>0;
	}
	
	
	
	
}
