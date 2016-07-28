<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class=main-div>
		<form action="addPerson" method="post">
			<div class="reg-form">
				<div class="field">
					<p>
						<label for="fname">First Name</label> <input class="input"
							type="text" id="fname" name="fname" placeholder="Ivan" required>
					</p>
					<c:if test="${not empty errorfname}">
						<p class="fail">${errorfname}</p>
					</c:if>
				</div>

				<div class="field">
					<p>
						<label for="">Last Name</label> <input class="input" type="text"
							id="lname" name="lname" placeholder="Melnik" required>
					</p>
					<c:if test="${not empty errorlname}">
						<p class="fail">${errorlname}</p>
					</c:if>
				</div>

				<div class="field">
					<p>
						<label for="email">Email</label> <input class="input" type="text"
							id="email" name="email" placeholder="test@gmail.com" required>
					</p>
					<c:if test="${not empty erroremail}">
						<p class="fail">${erroremail}</p>
					</c:if>
				</div>

				<div class="field">
					<p>
						<label for="password">Password</label> <input class="input"
							type="password" id="password" name="password"
							placeholder="for example: !asR5@ew" required>
					</p>
					<c:if test="${not empty errorpassword}">
						<p class="fail">${errorpassword}</p>
					</c:if>
				</div>

				<div class="field">
					<p>
						<label for="rep-password">Repeat</label> <input class="input"
							type="password" id="rep-password" name="rep-password"
							placeholder="for example: !asR5@ew" required>
					</p>
					<c:if test="${not empty errorrepeat}">
						<p class="fail">${errorrepeat}</p>
					</c:if>
				</div>

				<div class="field">
					<p>
						<label for="is-chef">I'm chef!</label> <input type="checkbox"
							id="is-chef" name="is-chef">
					</p>
				</div>

				<div class="field">
					<p>
						<label for="is-admin">I'm admin!</label> <input type="checkbox"
							id="is-admin" name="is-admin">
					</p>
				</div>

				<button type="submit">Register!</button>

				<div class="switch-log">
					<p>
						Already have an account? <a href="login">Click here</a>
					</p>
				</div>

			</div>
		</form>

		<p class="success">${message}</p>
		<p class="fail">${error}</p>

	</div>
</body>
</html>