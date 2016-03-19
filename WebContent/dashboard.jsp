<!DOCTYPE html>
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
		<ul class="header">
			<li class=header-menu-item><a href="index.jsp" class="menu-link">Home</a></li>
			<li class=header-menu-item><a href="add.jsp" class="menu-link">Add</a></li>
			<li class=active-header-menu-item><a href="dashboard.jsp" class="menu-link">Dashboard</a></li>
		</ul>
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
					<td>1</td>
					<td><input class="disabled" name="title" type="text" value="<% meal.getTitle(); %>" readonly></td>
					<td><input class="disabled" name="description" type="text" value="<%meal.getDescription(); %>" readonly></td>
					<td><input class="disabled" name="available" type="text" value="<%meal.isAvailable(); %>" readonly></td>
					<td><input class="disabled" name="price" type="text" value="<%meal.getPrice(); %>" readonly></td>
					<td><input class="disabled" name="owner" type="text" value="<%meal.getOwner(); %>" readonly></td>
					<td><input type="submit" value="Delete"></td>
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