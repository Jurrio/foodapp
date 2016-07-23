<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<fieldset class="reg-form">
				<div class="field">
					<label for="fname">First Name</label> <input type="text" id="fname"
						name="fname" placeholder="Ivan" required>
				</div>

				<div class="field">
					<label for="">Last Name</label> <input type="text" id="lname"
						name="lname" placeholder="Melnik" required>
				</div>

				<div class="field">
					<label for="email">Email</label> <input type="text" id="email"
						name="email" placeholder="test@gmail.com" required>
				</div>

				<div class="field">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" placeholder="for example: !asR5@ew"
						required>
				</div>

				<div class="field">
					<label for="rep-password">Repeat</label> <input type="password"
						id="rep-password" name="rep-password"
						placeholder="for example: !asR5@ew" required>
				</div>

				<div class="field">
					<label for="is-chef">I'm chef!</label> <input type="checkbox"
						id="is-chef" name="is-chef">
				</div>

				<div class="field">
					<label for="is-admin">I'm admin!</label> <input type="checkbox"
						id="is-admin" name="is-admin">
				</div>

				<button type="submit">Register!</button>
			</fieldset>
		</form>

		<p class="success">${message}</p>
		<p class="fail">${error}</p>

		<div class="switch-log">
			<p>
				Already have an account? <a href="login">Click here</a>
			</p>
		</div>
	</div>
</body>
</html>