package com.cart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cart.dao.ProductDao;
import com.cart.dto.Product;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/createproduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setProductName(request.getParameter("productname"));
		product.setProductDesc(request.getParameter("description"));
		product.setProductPrice(Float.valueOf(request.getParameter("price")));
		product.setImage(request.getParameter("productupload"));
		product.setCategory(request.getParameter("category"));
		
		//HttpSession session = request.getSession();
				//String username = (String) session.getAttribute("user");
		/*product.setProductTitle(request.getParameter("producttitle"));
		product.setProductDesc(request.getParameter("description"));
		product.setProductQty(Integer.parseInt(request.getParameter("qty")));
		String uploadTesting = "C:\\Users\\Amarendar\\Desktop\\" + request.getParameter("productupload");
		FileInputStream inputStream = new FileInputStream(new File(uploadTesting));*/
		/*		//request.getParameter("C:\\Users\\Amarendar\\Desktop" + "productupload")));
		System.out.print("Image: " + inputStream);
		product.setImage(inputStream);*/
		ProductDao productdao=new ProductDao();
		try {
			productdao.createProduct(product);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}
		
		
RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminHome.jsp");
rd.include(request,response);

		//response.sendRedirect("./jsp/success.jsp");
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	}
	
	

