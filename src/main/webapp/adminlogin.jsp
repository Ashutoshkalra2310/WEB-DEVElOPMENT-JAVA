<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
}

.login-container {
    width: 300px;
    margin: 100px auto;
    background-color: #fff;
    border-radius: 5px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 3px;
}

input[type="submit"] {
    padding: 10px;
    background-color:rgba(0,0,0,0.7);
    color: #fff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color:#000;
}
	
</style>
</head>
<body>
	<div class="login-container">
        <h2>Admin Login</h2>
        <form action="adminlogin" method="post">
            <label for="username">Username</label>
            <input id="username" type="text" name="username">

            <label for="password">Password</label>
            <input id="password" type="password" name="password">

            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>