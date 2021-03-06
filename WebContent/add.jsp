<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add meal</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<c:set var="pageName" value="add"/>
		<%@ include file="header.jsp"%>
		<p>Please add the product</p>
		<form action="addMeal" method="post">
			<table class="add-form">
				<tr><td>Title</td><td><input type="text" name="title" required></td>
				<tr><td>Description</td><td><textarea name="description" required></textarea></td><!-- TODO: сделать выше -->
				<tr><td>Available</td><td><input type="checkbox" name="available"></td></tr>
				<tr><td>Price</td><td><input type="number" name="price" min=0 step="0.01" required></td></tr>
				<tr><td>Owner</td><td><input type="text" name="owner" required></td></tr>
			</table>
			<input type="submit" value="Add meal" name="ok-button">
			<p class=success>${message}</p>
			<p class=fail>${error}</p>
		</form>	
	</body>
</html>