package com.ashutosh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String inputname= req.getParameter("username");
		String inputpassword = req.getParameter("password");
		if (inputname.equals("ashutosh") && inputpassword.equals("a")) {
			req.setAttribute("username",inputname);
		    RequestDispatcher rd= req.getRequestDispatcher("/request");
			rd.forward(req,res);
			
		}	
		else {
			res.sendRedirect("adminlogin.jsp");
		}
	}
}
