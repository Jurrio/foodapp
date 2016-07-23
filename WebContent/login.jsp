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
		<form action="login" method="post">
			<fieldset class="reg-form">
				<div class="field">
					<label for="email">Email</label> <input type="text" id="email"
						name="email" placeholder="test@gmail.com" required>
				</div>

				<div class="field">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" placeholder="for example: !asR5@ew"
						required>
				</div>
				<button type="submit">Sign in!</button>
			</fieldset>
		</form>

		${message}

		<div class="switch-log">
			<p>
				Not registered? <a href="addPerson">Click here</a>
			</p>
		</div>
	</div>
</body>
</html>