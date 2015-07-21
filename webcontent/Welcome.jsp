<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>welcome user</title>
</head>
<body>
	<%!HttpSession session;%>
	<%
		session = request.getSession(false);
	%>
	<center>
		<h2>welcome User</h2>
	</center>
	<center>
		<h4>Choose the product you want to purchase</h4>
	</center>
	<center>
		<a href="Show.jsp?Category=Pen">Pen</a>
	</center>
	<center>
		<a href="Show.jsp?Category=Book">Book</a>
	</center>
	<center>
		<a href="Show.jsp?Category=Novel">Novel</a>
	</center>
	<center>
		<a href="Cart"> see the cart</a>
	</center>
</body>
</html>