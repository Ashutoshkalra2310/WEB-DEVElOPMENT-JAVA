package com.ashutosh;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class RequestDao extends HttpServlet {
	public static void saveRequest(Request req) throws Exception{
		String url ="jdbc:postgresql://localhost:5432/ashutosh";
		String username ="postgres";
		String password = "root";
		String query = "INSERT INTO contact(name,email,message) VALUES(?,?,?)";
		
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparestatement = connection.prepareStatement(query);
		preparestatement.setString(1,req.getName());
		preparestatement.setString(2,req.getEmail());
		preparestatement.setString(3,req.getMessage());
		preparestatement.executeUpdate();
		
	}
}
