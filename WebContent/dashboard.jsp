<!DOCTYPE html>
<c:set var="pageName" scope="page" value="dashboard" />
<%@page import="com.candylife.model.Meal"%>
<%@page import="com.candylife.service.MealService"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Dashboard</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/table-style.css">
	</head>
	
	<body>
		<%@ include file="header.jsp"%>
		<br>
		<form action="findMeal" method="get">
			<input class="search-input" type="search" name="search" value="search field">
			<input class="search-button" type="submit" value="search">	
		</form>
		<br>
			<table class="dash-table">
				<tr>
					<td>#</td>
					<td>Title</td>
					<td>Description</td>
					<td>Available</td>
					<td>Price</td>
					<td>Owner</td>
					<td></td>
				</tr>
				<% for (Meal meal : MealService.showAll()) { %>
					<tr>
						<td><%= meal.getId() %></td>
						<td><input class="disabled" name="title" type="text" value="<%= meal.getTitle() %>" readonly></td>
						<td><input class="disabled" name="description" type="text" value="<%= meal.getDescription() %>" readonly></td>
						<td><input class="disabled" name="available" type="text" value="<%= meal.isAvailable() %>" readonly></td>
						<td><input class="disabled" name="price" type="text" value="<%= meal.getPrice() %>" readonly></td>
						<td><input class="disabled" name="owner" type="text" value="<%= meal.getOwner() %>" readonly></td>
						<td><form action="deleteMeal" method="get"><input type="hidden" name="id" value="<%= meal.getId() %>" ><input type="submit" value="Delete"></form></td>
					</tr>
				<% } %>
			<!--	<tr>
					<td>2</td>
					<td><input class="disabled" name="title" type="text" value="Strawberry salad" disabled></td>
					<td><input class="disabled" name="description" type="text" value="Mmmmm!" disabled></td>
					<td><input class="disabled" name="available" type="text" value="Yes" disabled></td>
					<td><input class="disabled" name="price" type="text" value="32" disabled></td>
					<td><input class="disabled" name="owner" type="text" value="Andy O." disabled></td>
					<td><input type="submit" value="Delete"></td>
				</tr>
				-->
			</table>
	</body>
</html>