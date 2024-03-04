package com.ashutosh;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputname= request.getParameter("username");
		String inputpassword = request.getParameter("password");
		User user = new User(inputname, inputpassword);
		boolean isValid = LoginDao.isValidUser(user);
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("username", inputname);
			response.sendRedirect("dashboard");
		}
		else {
			PrintWriter output = response.getWriter();
			response.setContentType("text/html");
			output.print("<h3 style='color: red; '>Invalid Credentails.</h3> <p style='color:red'>Please Try Again</p>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
			
		}
	}
}
