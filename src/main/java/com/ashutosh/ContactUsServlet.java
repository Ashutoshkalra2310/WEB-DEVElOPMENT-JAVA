package com.ashutosh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/contactus.jsp");
		dispatcher.forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= String.valueOf(request.getParameter("fname"));
		String email=String.valueOf(request.getParameter("email"));
		String message =String.valueOf(request.getParameter("msg"));
		Request details = new Request(name, email, message);
		try {
			RequestDao.saveRequest(details);
		}
		catch(Exception exception) {
			exception.getMessage();
		}
		PrintWriter output = response.getWriter();
		response.setContentType("text/html");
		output.print("<h3>Your query is submitted it will be resolved in 3-4 business days.</h3> <p> Feel free contact us again!!</p>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/contactus.jsp");
		dispatcher.include(request, response);
	}
}


