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
		<p>You are registered</p>
		<p>You will be redirected on start page in 3 seconds </p> 
		<p> <a href="homePage">click here for redirect to start page now</a> </p>
	</div>
</body>
</html>