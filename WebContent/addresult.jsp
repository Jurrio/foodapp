<%@page import="com.candylife.constants.RequestParam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add meal</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<ul class="header">
			<li class=header-menu-item><a href="homePage" class="menu-link">Home</a></li>
			<li class=active-header-menu-item><a href="addPage" class="menu-link">Add</a></li>
			<li class=header-menu-item><a href="dashboardPage" class="menu-link">Dashboard</a></li>
		</ul>
			<%  %>
			<% if (request.getAttribute("success").equals("yes")) { %>
			<p class=success> Success! <br>
			<% } else { %>
			<p class=fail> Fail! <br>
			<% } %>
			Result: <%= request.getAttribute("message") %> </p>			
	</body>
</html>