<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="">
<script type="text/javascript" src="resources/js/login.js"></script>
<style type="text/css">

	input,textarea{
	
		display: block;
		margin-bottom: 5px;
	
	}

</style>

</head>
<body>

<h1>Welcome to Spring MVC</h1>

<img alt="sdasdas" width="300px" height="300px" src="resources/images/1.jpg">

<h4 style="color:green">${successMsg }</h4>
<h4 style="color:red">${errMsg }</h4>

<form action="login">

	<input type="text" name="userName" placeholder="Enter User Name">
	<input type="password" name="password" placeholder="Enter Password ">
	<input type="submit" value="login">

</form>

</body>
</html>