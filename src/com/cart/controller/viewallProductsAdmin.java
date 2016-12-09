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
 * Servlet implementation class viewallProductsAdmin
 */
@WebServlet("/viewadminproducts")
public class viewallProductsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		request.getRequestDispatcher("./jsp/ViewProducts.jsp").forward(request,
				response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
