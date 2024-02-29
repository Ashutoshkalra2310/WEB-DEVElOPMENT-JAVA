package com.ashutosh;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Contactus")
public class Contactus extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String name= String.valueOf(req.getParameter("fname"));
		String email=String.valueOf(req.getParameter("email"));
		String msg =String.valueOf(req.getParameter("msg"));
		String url ="jdbc:postgresql://localhost:5432/ashutosh";
		String username ="postgres";
		String password = "root";
		String query = "INSERT INTO contact(name,email,message) VALUES(?,?,?)";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,name);
			st.setString(2, email);
			st.setString(3,msg);
			st.executeUpdate();
			PrintWriter out = res.getWriter();
			out.println("<h1>your query send to admin</h1>");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
