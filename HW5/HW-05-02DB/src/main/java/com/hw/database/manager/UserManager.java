package com.hw.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hw.database.entity.User;

public class UserManager {

	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String username = "postgres";
	private String password = "209152Ok";
	private String driver = "org.postgresql.Driver";
	private Connection connection;
	
	public UserManager() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public User findByUserNamePassword(String userName,String userPassword) throws SQLException {
		
		User user = null;
		
		connection = connect();
		
		String sql ="select * from \"user\" where userName = ? and userPassword = ?";
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, userPassword);
		ResultSet resultSet = statement.executeQuery();
		
		
		if(resultSet.next()) {
			user = parse(resultSet);
			return user;
		}
		
		disconnect();
		return user;
		
		
	}
	
	public User parse(ResultSet resultSet) throws SQLException{
		
		long userId = resultSet.getLong("userid");
		String userName = resultSet.getString("userName");
		String userPassword = resultSet.getString("userpassword");
		
		User user = new User(userId,userName,userPassword);
		
		return user;
	}
	
	public Connection connect() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}
	
	
	
}
