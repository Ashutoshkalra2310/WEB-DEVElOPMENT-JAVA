package com.ashutosh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;

public class RequestDao extends HttpServlet {
	static String url ="jdbc:postgresql://localhost:5432/ashutosh";
	static String username ="postgres";
	static String password = "root";
	public static void saveRequest(Request request) throws Exception{
		String query = "INSERT INTO contact(name,email,message) VALUES(?,?,?)";
		
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparestatement = connection.prepareStatement(query);
		preparestatement.setString(1,request.getName());
		preparestatement.setString(2,request.getEmail());
		preparestatement.setString(3,request.getMessage());
		preparestatement.executeUpdate();
	}
	public static List<Request> fetchRequests(Boolean isActive) {
		if(isActive) {
			List<Request> activeUser = new ArrayList<>();
			String activeQuery="SELECT * FROM contact WHERE status='Active' ORDER BY id";
			List<Request> activeData = new ArrayList<>();
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedstatement = connection.prepareStatement(activeQuery);
				ResultSet resultset=preparedstatement.executeQuery();	
				while(resultset.next()) {
					Request request = new Request();
					request.setId(Integer.parseInt(resultset.getString(1)));
					request.setName(resultset.getString(2));
					request.setEmail(resultset.getString(3));
					request.setMessage(resultset.getString(4));
					activeData.add(request);
				}
				return activeData;		
			}
			catch(Exception exception) {
				exception.getMessage();
			}
		}
		else {
			List<Request> archiveUser = new ArrayList<>();
			String archiveQuery="SELECT * FROM contact WHERE status='Archive' ORDER BY id";
			List<Request> archiveData = new ArrayList<>();
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedstatement = connection.prepareStatement(archiveQuery);
				ResultSet resultset=preparedstatement.executeQuery();	
				while(resultset.next()) {
					Request request = new Request();
					request.setId(Integer.parseInt(resultset.getString(1)));
					request.setName(resultset.getString(2));
					request.setEmail(resultset.getString(3));
					request.setMessage(resultset.getString(4));
					archiveData.add(request);
				}
				return archiveData;		
			}
			catch(Exception exception) {
				exception.getMessage();
			}
		}
		List<Request> request= new ArrayList<>();
		return request;
	}
	public static void changeStatus(int requestId, boolean status) {
		int id = requestId;
		String query="";
		if(status) {
			query = "UPDATE contact SET status = 'Active' WHERE id = ?";
		}
		else {
			query = "UPDATE contact SET status = 'Archive' WHERE id = ?";
		}
		try{
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1,id);
			preparedstatement.executeUpdate();
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
