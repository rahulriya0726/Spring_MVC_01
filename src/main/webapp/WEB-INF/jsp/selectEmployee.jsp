<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/home.js' />"></script>
<style type="text/css">

	input,textarea{
	
		display: block;
		margin-bottom: 5px;
	
	}

</style>

</head>
<body>

<h1>Welcome to Spring MVC</h1>

<form action="selectEmpIloyeeById">

    <input type="text" name="id" placeholder="Enter Id">
    <input type="submit" value="Select Employee">

</form>

</body>
</html>