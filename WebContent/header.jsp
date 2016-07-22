<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String pageName = ""; %>
	<ul class="header">
		<li 
			<% if (pageName.equals("index")) { 
				%> class="active-header-menu-item" <% 
			} else { 
				%> class="header-menu-item" <% 
			} %> >
		
			<a href="homePage" class="menu-link">Home</a>
		</li>
		
		<li 
			<% if (pageName.equals("add")) { 
				%> class="active-header-menu-item" <% 
			} else { 
				%> class="header-menu-item" <% 
			} %> >
			<a href="addMeal" class="menu-link">Add</a>
		</li>
		
		<li 
			<% if (pageName.equals("dashboard")) { 
				%> class="active-header-menu-item" <%
			} else { 
				%> class="header-menu-item" <% 
			} %> >
			
			<a href="listMeal" class="menu-link">Dashboard</a>
		</li>
		
		<li class="right-menu-item">
			<a href="addPerson">Registration</a>

		</li>
		
		<li class="right-menu-item">
			<a href="LoginController">Sign in</a>
		</li>
	</ul>