package com.cart.controller;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.CartDao;
import com.cart.dto.Cart;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int product_id=Integer.parseInt(request.getParameter("AddtoCart"));
		HttpSession session=request.getSession();
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String uname=(String)session.getAttribute("user");
		System.out.println(uname);
		System.out.println(product_id);
		System.out.println(quantity);
		
		Cart cart = new Cart();
		cart.setProduct_id(product_id);
		cart.setQuantity(quantity);
		cart.setUsername(uname);
		
		CartDao cartDao=new CartDao();
		try {
			cartDao.addItemsToCart(cart);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}
		
		request.getRequestDispatcher("./UserHome.jsp").forward(request,
				response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doPost(request,response);
	}

}
