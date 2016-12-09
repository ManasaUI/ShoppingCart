package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.UserDao;
import com.cart.dto.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUname(request.getParameter("UserName"));
		user.setFname(request.getParameter("FirstName"));
		user.setLname(request.getParameter("LastName"));
		user.setPassword(request.getParameter("Password"));
		user.setEmail(request.getParameter("Email"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("Phone"));
		UserDao userdao = new UserDao();
		try {
			userdao.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/Welcome.html");
		out.println("<b><i><font color=red size=4>Registration Successfull!! Please Login.</font></b></i>\n");
		rd.include(request, response);
	}
}
