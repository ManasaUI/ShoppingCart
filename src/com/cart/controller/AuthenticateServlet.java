package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.AuthenticateDao;


@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String errorMessage = "";
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
        AuthenticateDao authenticatedao=new AuthenticateDao();
        if(username.equals("admin")&&password.equals("admin"))
        {
        	HttpSession session=request.getSession();
			session.setAttribute("user", username);
        	response.sendRedirect("AdminHome.jsp");
        	
        }
		try {
			String result=authenticatedao.Authenticate(username,password);
			if (result.equals("success")) {
				HttpSession session=request.getSession();
				session.setAttribute("user", username);
				response.sendRedirect("UserHome.jsp");
			} else if (result.equals("wrongpassword")) {
				errorMessage = "Wrong Password. Please enter correct password.";

			} else {
				errorMessage = "Please register if you are logging in for the first time.";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Welcome.html");
			out.println("<b><i><font color=red size=4>" + errorMessage
					+ "</font></b></i>\n");
			rd.include(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
