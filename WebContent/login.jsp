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
		<form action="LoginController" method="post">
			<div class="reg-form">
			
				<div class="field">
					<p><label for="email">Email</label> <input class="input" type="text"
						id="email" name="email" placeholder="test@gmail.com" required></p>
				</div>

				<div class="field">
					<p><label for="password">Password</label> <input class="input"
						type="password" id="password" name="password"
						placeholder="for example: !asR5@ew" required></p>
				</div>
			
				<button type="submit">Sign in!</button>
			
				<p><label for="remember"><input name="remember" type="checkbox"
					value="" />Remember me!</label></p>
			
				<div class="switch-log">
					<p>
						Not registered? <a href="addPerson">Click here</a>
					</p>
				</div>
			
			</div>
		</form>

		<p class="success">${message}</p>
		<p class="fail">${error}</p>

	</div>
</body>
</html>