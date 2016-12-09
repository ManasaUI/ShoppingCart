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

import com.cart.dao.OrderDetailsDao;
import com.cart.dto.OrderItem;

/**
 * Servlet implementation class ViewOrderServlet
 */
@WebServlet("/ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
    	List<ArrayList<OrderItem>> arrayorderlist=new ArrayList<ArrayList<OrderItem>>();
    	OrderDetailsDao orderDetailsDao=new OrderDetailsDao();
    

 try {
	 arrayorderlist=orderDetailsDao.retrieveOrders(username);
	 if(arrayorderlist.isEmpty())
	 {
		 request.getRequestDispatcher("UserHome.jsp").forward(request,
					response);
	 }
 else {
				ArrayList<Float> totalPrice = new ArrayList<Float>();
				for (ArrayList<OrderItem> orders : arrayorderlist) {
					float total = 0;
					for (OrderItem item : orders) {
						System.out.println(item.getPrice() + " " + item.getQuantity());
						total = total + (item.getPrice() * item.getQuantity());
					}

					totalPrice.add(total);
					System.out.println(total);
					System.out.println("---------------");
				}

				request.setAttribute("arrayOfOrders", arrayorderlist);
				request.setAttribute("totalprice", totalPrice);
			}

		} 
 catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}    		
 
 request.getRequestDispatcher("./jsp/viewOrders.jsp").forward(request,
			response);
	}

}
