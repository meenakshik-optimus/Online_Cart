<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.javalearn.domain.online_shopping.ProductCounts"%>
<%@ page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!HttpSession session;%>
	<%
		session = request.getSession(false);
	%>
	<form method="post" action="AddToCart">
		<table border='1' style='width: 100%'>
			<tr>
				<td>category</td>
				<td>ProductName</td>
				<td>ProductAvailable</td>
				<td>Price</td>
				<td>enter the Quantity</td>
			</tr>
			<%!String category;%>
			<%
				category = request.getParameter("Category");
			%>
			<%
				session.setAttribute("Category", category);
			%>
			<%!ResultSet resultset;%>
			<%
				resultset = new ProductCounts().getResultSet(category);
			%>
			<%
				while (resultset.next()) {
			%>
			<tr>
				<td><%=resultset.getString("Category")%></td>

				<td><%!String name;%> <%
 	name = resultset.getString("ProductName");
 %>
					<%=resultset.getString("ProductName")%></td>


				<td><%=resultset.getString("ProductAvailable")%></td>

				<td><%=resultset.getString("Price")%></td>

				<td><input type="text" name="quantity"></td>

				<td><input type="checkbox" name="Category" value=<%=name%>>
			</tr>

			<%
				}
			%>
		</table>


		<input type="submit" value="Add To Cart" />
	</form>

</body>
</html>