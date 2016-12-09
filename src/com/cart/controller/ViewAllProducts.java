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
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDao;
import com.cart.dto.Product;

/**
 * Servlet implementation class ViewAllPosts
 */
@WebServlet("/viewallproducts")
public class ViewAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String username = (String) session.getAttribute("user");
		 ProductDao productdao=new ProductDao();
		List<Product> productList = new ArrayList<Product>();
		try {

			productList = productdao.ViewAllProducts();
			for (Product product : productList) {
				System.out.println(product.getProductName());
			}

			request.setAttribute("productList", productList);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}
		request.getRequestDispatcher("./jsp/viewAllProducts.jsp").forward(request,
				response);
	}
}
