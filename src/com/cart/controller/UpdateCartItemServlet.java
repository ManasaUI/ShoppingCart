package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class UpdateCartItemServlet
 */
@WebServlet("/updateCartItem")
public class UpdateCartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pid=Integer.parseInt(request.getParameter("update"));
	int qty=Integer.parseInt(request.getParameter("quantity"));
	HttpSession session=request.getSession();
	String uname=(String)session.getAttribute("user");
	Cart cart = new Cart();
	cart.setProduct_id(pid);
	cart.setQuantity(qty);
	cart.setUsername(uname);
	
	CartDao cartDao=new CartDao();

    try {
		cartDao.updateCartItem(cart);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    request.getRequestDispatcher("/ViewCartServlet").forward(request,
			response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);	
	}

	
	

}
