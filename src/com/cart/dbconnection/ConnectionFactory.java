package com.cart.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 //String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
						   "databaseName=ShoppingCart;user=sa;password=manasa;");
	}
}
