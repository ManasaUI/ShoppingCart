package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cart.dbconnection.ConnectionFactory;

public class AuthenticateDao {

	ConnectionFactory connectionFactory = new ConnectionFactory();
     Connection connection;
	 PreparedStatement preparedStatement;
	public String Authenticate(String username, String password)
			throws ClassNotFoundException, SQLException {
		String query = "SELECT UNAME,PASSWORD FROM USERS WHERE UNAME=? OR PASSWORD=?";

		
		connection = connectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet rs = preparedStatement.executeQuery();
		String result = "invaliduser";
		while (rs.next()) {
			Boolean condition1 = username.equalsIgnoreCase(rs
					.getString("UNAME"));
			Boolean condition2 = password.equalsIgnoreCase(rs
					.getString("PASSWORD"));
			if (condition1 && condition2)
				result = "success";
			else if (condition1)
				result = "wrongpassword";
		}
		closeConnections();
		return result;
	}
	
	private void closeConnections() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	
}
}
