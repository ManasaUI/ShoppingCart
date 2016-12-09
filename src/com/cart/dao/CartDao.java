package com.cart.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cart.dbconnection.ConnectionFactory;
import com.cart.dto.Cart;
import com.cart.dto.CustomerCart;

public class CartDao {
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void addItemsToCart(Cart cart) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String searchQuery = "SELECT cart_id,  quantity from cart WHERE product_id=? AND uname=?";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(searchQuery);
		preparedStatement.setInt(1, cart.getProduct_id());
		preparedStatement.setString(2, cart.getUsername());

		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			int cart_id = rs.getInt("cart_id");
			int quantity = rs.getInt("quantity");

			String updateQuery = "UPDATE  cart SET  quantity =? WHERE  cart_id= ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, quantity + cart.getQuantity());
			preparedStatement.setInt(2, cart_id);
			preparedStatement.executeUpdate();
		} else {
			String insertQuery = "INSERT into cart" + "(product_id, uname, quantity)" + "VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, cart.getProduct_id());
			preparedStatement.setString(2, cart.getUsername());
			preparedStatement.setInt(3, cart.getQuantity());
			preparedStatement.executeUpdate();
		}

		closeConnections();
	}

	public void updateCartItem(Cart cart) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String updateQuery = "Update cart SET Quantity = ? WHERE product_id=? AND uname=?";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setInt(1, cart.getQuantity());
		preparedStatement.setInt(2, cart.getProduct_id());
		preparedStatement.setString(3, cart.getUsername());
		preparedStatement.executeUpdate();
		closeConnections();
	}

	public void deleteCartItem(Cart cart) throws ClassNotFoundException, SQLException, FileNotFoundException {

		String updateQuery = "Delete from cart WHERE product_id=? AND uname=?";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setInt(1, cart.getProduct_id());
		preparedStatement.setString(2, cart.getUsername());
		preparedStatement.executeUpdate();
		closeConnections();
	}

	public ArrayList<CustomerCart> retrieveCustomerCart(String uname) throws SQLException, ClassNotFoundException {
		ArrayList<CustomerCart> customerOrders = new ArrayList<CustomerCart>();

		String retrieveOrder = "SELECT c.uname, p.product_id, c.quantity, p.product_name,p.product_desc, p.price,p.image "
				+ "FROM Cart c JOIN Product  p " + "ON  c.product_id =  p.product_id AND c.uname = ?;";

		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(retrieveOrder);
		preparedStatement.setString(1, uname);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			CustomerCart customerOrder = new CustomerCart();
			customerOrder.setUname(uname);
			customerOrder.setProduct_name(rs.getString("product_name"));
			customerOrder.setImage(rs.getString("image"));
			customerOrder.setProduct_desc(rs.getString("product_desc"));
			customerOrder.setProduct_id(rs.getInt("product_id"));
			customerOrder.setProduct_name(rs.getString("product_name"));
			customerOrder.setQuantity(rs.getInt("quantity"));
			customerOrder.setPrice(rs.getFloat("price") * rs.getInt("quantity"));
			customerOrders.add(customerOrder);
		}
		closeConnections();
		return customerOrders;
	}

	private void closeConnections() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		Cart x = new Cart();
		x.setProduct_id(4);
		x.setQuantity(10);
		x.setUsername("amar");

		CartDao y = new CartDao();
		y.deleteCartItem(x);
	}
}
