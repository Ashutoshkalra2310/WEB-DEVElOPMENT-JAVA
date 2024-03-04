<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request</title>
</head>
<body>
<h1>Hello Admin</h1>
<br/>
<br/>
<h3>Active Data</h3>
<br>
    <table border="1">
        <thead>
            <tr>
            	<th>Status</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ActiveQuerieList}" var="data">
            	<tr>
                	<td>
	            		<form action="dashboard" method="post">
	            			<input type="hidden" value="${data.id}" name="archive" > 
	            			<button type="submit">Archive</button>
	            		</form>
            		</td>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.email}</td>
                    <td>${data.message}</td>
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
            	<th>Status</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ArchiveQuerieList}" var="data">
                <tr>
                	<td>
	            		<form action="dashboard" method="post">
	            			<input type="hidden" value="${data.id}" name="active" > 
	            			<button type="submit">Active</button>
	            		</form>
            		</td>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.email}</td>
                    <td>${data.message}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
