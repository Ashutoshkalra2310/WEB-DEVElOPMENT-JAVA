package com.ashutosh;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

public class LoginDao {
	public static boolean isValidUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (username.equals("ashutosh") && password.equals("a")) {
			return true;	
		}	
		else {
			return false;
		}
	}
}
