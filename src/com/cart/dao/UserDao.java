package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cart.dbconnection.ConnectionFactory;
import com.cart.dto.User;


public class UserDao {
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void updateUser(User user) throws SQLException,
			ClassNotFoundException {

		String insertQuery = "INSERT into Users(uname, fname, lname,password,address,phone,email )"
				+ "VALUES(?,?,?,?,?,?,?)";
		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, user.getUname());
		preparedStatement.setString(2, user.getFname());
		preparedStatement.setString(3, user.getLname());

		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.setString(6, user.getPhone());
		preparedStatement.setString(7,user.getEmail());
		preparedStatement.executeUpdate();
		closeConnections();
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
