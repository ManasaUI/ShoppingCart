package com.cart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.ProductDao;
import com.cart.dto.Product;

/**
 * Servlet implementation class SearchCategoryServlet
 */
@WebServlet("/SearchCategoryServlet")
public class SearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		ProductDao productdao = new ProductDao();
		List<Product> productList = new ArrayList<Product>();

		switch (operation) {
		case "grocery":
			try {
				productList = productdao.categorySearch("grocery");
				request.setAttribute("productList", productList);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "electronics":
			try {
				productList = productdao.categorySearch("electronics");
				request.setAttribute("productList", productList);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "fashion":

			try {
				productList = productdao.categorySearch("fashion");
				request.setAttribute("productList", productList);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "toys":
			try {
				productList = productdao.categorySearch("toys");
				request.setAttribute("productList", productList);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			break;
		default:

		}

		request.getRequestDispatcher("./jsp/viewAllProducts.jsp").forward(request, response);

	}

}
