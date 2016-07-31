<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<ul class="header">
	<c:choose>
		<c:when test="${pageName ne 'index'}">
			<li class="header-menu-item"><a href="homePage"
				class="menu-link">Home</a></li>
		</c:when>
		<c:otherwise>
			<li class="active-header-menu-item"><a href="homePage"
				class="menu-link">Home</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageName ne 'add'}">
			<li class="header-menu-item"><a href="addMeal" class="menu-link">Add</a></li>
		</c:when>
		<c:otherwise>
			<li class="active-header-menu-item"><a href="addMeal"
				class="menu-link">Add</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageName ne 'dashboard'}">
			<li class="header-menu-item"><a href="listMeal"
				class="menu-link">Dashboard</a></li>
		</c:when>
		<c:otherwise>
			<li class="active-header-menu-item"><a href="listMeal"
				class="menu-link">Dashboard</a></li>
		</c:otherwise>
	</c:choose>

	<c:if test="${empty user}">
		<li class="right-menu-item"><a href="addPerson" class="menu-link">Registration</a></li>

		<li class="right-menu-item"><a href="LoginController"
			class="menu-link">Sign in</a></li>
	</c:if>
	<c:if test="${not empty user}">
		<li class="right-menu-item"><a href="profileController"
			class="menu-link">${user.firstName} ${user.lastName}</a></li>
		<li class="right-menu-item"><a href="LogoutController"
			class="menu-link">Logout</a></li>
	</c:if>
</ul>