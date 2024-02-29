package com.ashutosh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

public class ResultsDao{
	public static List<Data> sendData(String query) {
		String url ="jdbc:postgresql://localhost:5432/ashutosh";
		String username ="postgres";
		String password = "root";
		List<Data> listOfData = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();	
			while(rs.next()) {
				Data data = new Data();
				data.setId(Integer.parseInt(rs.getString(1)));
				data.setName(rs.getString(2));
				data.setEmail(rs.getString(3));
				data.setMessage(rs.getString(4));
				listOfData.add(data);
			}
			return listOfData;		
		}
		catch(Exception e) {
			e.getMessage();
		}
		return listOfData;
	}
}
