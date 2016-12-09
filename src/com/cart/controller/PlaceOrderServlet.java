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

import com.cart.dao.OrderDetailsDao;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	String username=(String)session.getAttribute("user");
	

		String billingaddress=request.getParameter("Addressline1")+" " +request.getParameter("Addressline2") +" "+request.getParameter("City");
		String shippingaddress=request.getParameter("Addresline1")+" " +request.getParameter("Addresline2") +" "+request.getParameter("Cityname");
System.out.println(username+" "+billingaddress+" "+shippingaddress);
		
		OrderDetailsDao orderdetailsdao=new OrderDetailsDao();
		
		try {
			orderdetailsdao.placeOrder(username, billingaddress, shippingaddress);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("UserHome.jsp").forward(request,
				response);
		
	}
	

}
