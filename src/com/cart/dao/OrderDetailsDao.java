package com.cart.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cart.dbconnection.ConnectionFactory;
import com.cart.dto.OrderItem;

public class OrderDetailsDao {

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection;
	private PreparedStatement preparedStatement;

	public List<ArrayList<OrderItem>> retrieveOrders(String uname) throws SQLException, ClassNotFoundException {
		List<ArrayList<OrderItem>> orderDetails = new ArrayList<ArrayList<OrderItem>>();

		String retrieveDistinctOrderId = "SELECT DISTINCT order_id, OrderDate FROM Order_Details WHERE uname=? ORDER  BY OrderDate DESC";
		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(retrieveDistinctOrderId);
		preparedStatement.setString(1, uname);
		ResultSet rsDistinctOrderId = preparedStatement.executeQuery();

		while (rsDistinctOrderId.next()) {
			ArrayList<OrderItem> individualOrderDetails = new ArrayList<OrderItem>();
			String orderID = rsDistinctOrderId.getString("order_id");

			String retrieveOrder = "SELECT o.order_id, o.uname, o.orderdate, p.product_id, o.quantity, p.product_name,p.product_desc, p.price,p.image "
					+ "FROM Order_Details o JOIN Product  p "
					+ "ON  o.product_id =  p.product_id AND o.uname = ? AND order_id = ?";

			preparedStatement = connection.prepareStatement(retrieveOrder);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, orderID);
			ResultSet rsOrderItem = preparedStatement.executeQuery();

			while (rsOrderItem.next()) {
				OrderItem individualItem = new OrderItem();
				individualItem.setOrderid(rsOrderItem.getString("order_id"));
				individualItem.setProductId(rsOrderItem.getInt("product_id"));
				individualItem.setQuantity(rsOrderItem.getInt("quantity"));
				individualItem.setProductName(rsOrderItem.getString("product_name"));
				individualItem.setProductDesc(rsOrderItem.getString("product_desc"));
				individualItem.setPrice(rsOrderItem.getFloat("price"));
				individualItem.setImage(rsOrderItem.getString("image"));
				individualItem.setOrderDate(rsOrderItem.getTimestamp("Orderdate"));
				individualOrderDetails.add(individualItem);
			}
			orderDetails.add(individualOrderDetails);
		}
		closeConnections();
		return orderDetails;
	}

	public void placeOrder(String uname, String billingAddress, String shippingAddress)
			throws ClassNotFoundException, SQLException, FileNotFoundException {

		String retrieveCartQuery = "SELECT   cart_id, product_id, quantity, uname FROM cart WHERE uname = ?";
		connection = connectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(retrieveCartQuery);
		preparedStatement.setString(1, uname);

		ResultSet rs = preparedStatement.executeQuery();

		Timestamp orderDate = new Timestamp(System.currentTimeMillis());
		UUID orderId = UUID.randomUUID();

		while (rs.next()) {
			String insertOrderQuery = "INSERT INTO Order_Details (order_id,  product_id, quantity, uname, ShippingAddress, BillingAddress, OrderDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertOrderQuery);
			preparedStatement.setString(1, orderId.toString());
			preparedStatement.setInt(2, rs.getInt("product_id"));
			preparedStatement.setInt(3, rs.getInt("quantity"));
			preparedStatement.setString(4, uname);
			preparedStatement.setString(5, shippingAddress);
			preparedStatement.setString(6, billingAddress);
			preparedStatement.setTimestamp(7, orderDate);
			preparedStatement.executeUpdate();
		}

		String queryToDeleteUserCart = "DELETE  FROM CART WHERE  UNAME = ?";
		preparedStatement = connection.prepareStatement(queryToDeleteUserCart);
		preparedStatement.setString(1, uname);
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

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {

		OrderDetailsDao x = new OrderDetailsDao();
		List<ArrayList<OrderItem>> test = x.retrieveOrders("cherry");

		for (ArrayList<OrderItem> i : test) {
			for (OrderItem item : i) {
				System.out.println("----------------------------------");
				System.out.println(item.toString());
			}
			
			System.out.println("----------------------------------");
			System.out.println("----------------------------------");

		}

	}
}
