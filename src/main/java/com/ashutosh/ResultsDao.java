package com.ashutosh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

public class ResultsDao{
	static String url ="jdbc:postgresql://localhost:5432/ashutosh";
	static String username ="postgres";
	static String password = "root";
	public static void changeStatus(String query , int id) throws ClassNotFoundException, SQLException {
		try {
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
	public static List<Data> sendData(String query) {
		List<Data> listOfData = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			ResultSet resultset=preparedstatement.executeQuery();	
			while(resultset.next()) {
				Data data = new Data();
				data.setId(Integer.parseInt(resultset.getString(1)));
				data.setName(resultset.getString(2));
				data.setEmail(resultset.getString(3));
				data.setMessage(resultset.getString(4));
				listOfData.add(data);
			}
			return listOfData;		
		}
		catch(Exception exception) {
			exception.getMessage();
		}
		return listOfData;
	}
}
