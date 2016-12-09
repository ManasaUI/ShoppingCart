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

/**
 * Servlet implementation class DeleteCartItemServlet
 */
@WebServlet("/deleteCartItem")
public class DeleteCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int product_id=Integer.parseInt(request.getParameter("delete"));
		HttpSession session=request.getSession();
		int qty=Integer.parseInt(request.getParameter("quantity"));
		String uname=(String)session.getAttribute("user");

		
		Cart cart = new Cart();
		cart.setProduct_id(product_id);
		cart.setQuantity(qty);
		cart.setUsername(uname);
		System.out.println(cart.getCart_id()+" "+cart.getProduct_id()+" "+cart.getUsername());
		
		CartDao cartdao=new CartDao();
		try {
			System.out.println("try begin");
			cartdao.deleteCartItem(cart);
			System.out.println("try end:");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/ViewCartServlet").forward(request,
				response);
		
		
	}

}
