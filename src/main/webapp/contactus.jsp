<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* light grey */
            text-align: center;
            padding: 20px;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            color: #333; /* dark grey */
            margin-bottom: 10px;
        }

        h2 {
            color: #666; /* medium grey */
            margin-bottom: 30px;
        }

        form {
            max-width: 400px;
            padding: 20px;
            background-color: #fff; /* white */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* soft shadow */
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333; /* dark grey */
            text-align: left;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc; /* light grey */
            border-radius: 4px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #000; /* black */
            color: #fff; /* white */
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #333; /* darker grey on hover */
        }
</style>
</head>
<body>
	<div class="container">
        <form action="Contactus" method="post">
            <h1>Contact Us</h1>
            <h2>Please Fill This Form</h2>
            <label for="fname">Full Name</label>
            <input id="fname" type="text" name="fname">
            
            <label for="email">Email</label>
            <input id="email" type="text" name="email">
            
            <label for="msg">Message</label>
            <textarea id="msg" type="text" name="msg" rows="4" cols="50"></textarea>
            
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>