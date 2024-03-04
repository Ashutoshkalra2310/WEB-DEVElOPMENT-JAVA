package com.ashutosh;

public class User {
	String username;
	String password;
	User(String username, String password){
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
    return username;
    }
    public void setUsername(String Username) {
        this.username = Username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "username='" + username + '\'' +
               ", password='" + password + '\'';
    }
}
