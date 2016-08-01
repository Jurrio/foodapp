<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Hello on board!</title>
</head>

<body>
	<script>
		onload = function () {setTimeout ("document.location = 'homePage';", 3 * 1000)}
	</script>
	<div class="congrats">
		<p>Hello, ${user}</p>
		<p>Thank you for your visit! Back to us!</p>
		<form action="LogoutController" method="post">
			<button type="submit" name="your_name" value="your_value"
				class="btn-link">click here for redirect to start page now</button>
		</form>
	</div>
</body>
</html>