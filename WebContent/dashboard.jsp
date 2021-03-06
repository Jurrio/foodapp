<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/table-style.css">
</head>

<body>
	<c:set var="pageName" value="dashboard" />
	<%@ include file="header.jsp"%>
	<br>
	<form action="findMeal" method="post">
		<input class="search-input" type="search" name="search"
			placeholder="search field"> <input class="search-button"
			type="submit" value="search">
	</form>
	<br>
	<p class="success">${message}</p>
	<p class="fail">${error}</p>
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
		<c:forEach items="${meals}" var="meal">
			<tr>
				<td>${meal.id}</td>
				<td><input class="disabled" name="title" type="text"
					value="${meal.title}" readonly></td>
				<td><input class="disabled" name="description" type="text"
					value="${meal.description}" readonly></td>
				<td><input class="disabled" name="available" type="text"
					value="${meal.available}" readonly></td>
				<td><input class="disabled" name="price" type="text"
					value="${meal.price}" readonly></td>
				<td><input class="disabled" name="owner" type="text"
					value="${meal.owner}" readonly></td>
				<td><form action="deleteMeal" method="post">
						<input type="hidden" name="id" value="${meal.id}"><input
							type="submit" value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>