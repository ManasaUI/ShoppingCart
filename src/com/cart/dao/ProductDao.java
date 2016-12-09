package com.cart.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.dbconnection.ConnectionFactory;
import com.cart.dto.Product;

public class ProductDao {
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void createProduct(Product product) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String insertQuery = "INSERT into product" + "(product_name,product_desc,price,image,category)"
				+ "VALUES(?,?,?,?,?)";
		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, product.getProductName());
		preparedStatement.setString(2, product.getProductDesc());
		preparedStatement.setFloat(3, product.getProductPrice());
		preparedStatement.setString(4, product.getImage());
		preparedStatement.setString(5, product.getCategory());
		preparedStatement.executeUpdate();
		closeConnections();
	}

	public List<Product> ViewAllProducts() throws SQLException, ClassNotFoundException {
		List<Product> productsList = new ArrayList<Product>();
		String RetreivQuery = "SELECT product_id, product_name, product_desc,price,image,category from product";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(RetreivQuery);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductDesc(rs.getString("product_desc"));
			product.setProductPrice(rs.getFloat("price"));
			product.setImage(rs.getString("image"));
			product.setCategory(rs.getString("category"));
			productsList.add(product);

		}
		return productsList;

	}

	public List<Product> searchProducts(String searchstring) throws ClassNotFoundException, SQLException {
		List<Product> productsList = new ArrayList<Product>();

		String searchQuery = "SELECT product_id,product_name, product_desc,price,image,category from product WHERE PRODUCT_NAME LIKE ?";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(searchQuery);
		preparedStatement.setString(1, "%" + searchstring + "%");

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductDesc(rs.getString("product_desc"));
			product.setProductPrice(rs.getFloat("price"));
			product.setImage(rs.getString("image"));
			product.setCategory(rs.getString("category"));
			productsList.add(product);

		}
		rs.close();
		closeConnections();
		return productsList;
	}

	public List<Product> categorySearch(String searchstring) throws ClassNotFoundException, SQLException {
		List<Product> productsList = new ArrayList<Product>();

		String searchQuery = "SELECT product_id,product_name, product_desc,price,image,category from product WHERE category=?";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(searchQuery);
		preparedStatement.setString(1, searchstring);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductDesc(rs.getString("product_desc"));
			product.setProductPrice(rs.getFloat("price"));
			product.setImage(rs.getString("image"));
			product.setCategory(rs.getString("category"));
			productsList.add(product);

		}
		rs.close();
		closeConnections();
		return productsList;
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
