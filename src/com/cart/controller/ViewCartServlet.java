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

import com.cart.dao.CartDao;
import com.cart.dto.CustomerCart;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartDao cartDao = new CartDao();
		List<CustomerCart> customerOrderCart = new ArrayList<CustomerCart>();
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("user");
		try {
			customerOrderCart = cartDao.retrieveCustomerCart(uname);
			if(customerOrderCart.isEmpty())
			{
				request.getRequestDispatcher("UserHome.jsp").forward(request, response);
			}
			else
			{
				float total=0;
				for (CustomerCart cartitem :customerOrderCart) {
					System.out.println(cartitem.getQuantity()+" "+cartitem.getPrice());					
					total=total+(cartitem.getPrice() * cartitem.getQuantity());
					
				}
				System.out.println(total);
				request.setAttribute("totalprice", total);
			request.setAttribute("customerOrderCart", customerOrderCart);
			request.getRequestDispatcher("./jsp/viewCart.jsp").forward(request, response);
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
