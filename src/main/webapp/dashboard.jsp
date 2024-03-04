<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
  body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        h1, h3 {
            color: #333;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        form {
            text-align: center;
        }

        button {
            padding: 8px 16px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border-radius: 4px;
        }

        button:hover {
            background-color: #45a049;
        }

        button[type="submit"] {
            margin-top: 10px;
        }
</style>
</head>
<body>
<% 
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username") == null){
	    response.sendRedirect("login");
	}
%>
<h1>Hello <%= session.getAttribute("username") %></h1>
<br/>
<br/>
<h3>Active Data</h3>
<br>
    <table border="1">
        <thead>
            <tr>
            	
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Change Status</th>   
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ActiveQuerieList}" var="data">
            	<tr>
                	
                    <td>${data.name}</td>
                    <td>${data.email}</td>
                    <td>${data.message}</td>
                    <td>
	            		<form action="dashboard" method="post">
	            			<input type="hidden" value="${data.id}" name="archiveid" > 
	            			<button type="submit">Archive</button>
	            		</form>
            		</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <h3>Archive Data</h3>
	<br>
    <table border="1">
        <thead>
            <tr>
            	
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Change Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ArchiveQuerieList}" var="data">
                <tr>
                	
                    <td>${data.name}</td>
                    <td>${data.email}</td>
                    <td>${data.message}</td>
                    <td>
	            		<form action="dashboard" method="post">
	            			<input type="hidden" value="${data.id}" name="activeid" > 
	            			<button type="submit">Active</button>
	            		</form>
            		</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="logout" id="logout">
		<button type="submit">Logout</button>
	</form>
</body>
</html>
