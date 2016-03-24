<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add meal</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<ul class="header">
			<li class=header-menu-item><a href="homePage" class="menu-link">Home</a></li>
			<li class=active-header-menu-item><a href="addPage" class="menu-link">Add</a></li>
			<li class=header-menu-item><a href="dashboardPage" class="menu-link">Dashboard</a></li>
		</ul>
		<p>Please add the product</p>
		<form action="addMeal" method="post">
			<table class="add-form">
				<tr><td>Title</td><td><input type="text" name="title" required></td>
				<tr><td>Description</td><td><textarea name="description" required></textarea></td><!-- TODO: сделать выше -->
				<tr><td>Type</td><td>
					<select name="type" required>
						<option value="#" disabled>Select a type</option>
						<option value="soup">Soup</option>
						<option value="main-course">Main_Course</option>
						<option value="desert">Desert</option>
					</select></td></tr>
				<tr><td>Available</td><td><input type="checkbox" name="available"></td></tr>
				<tr><td>Price</td><td><input type="number" name="price" min=0 step="0.01" required></td></tr>
				<tr><td>Owner</td><td><input type="text" name="owner" required></td></tr>
			</table>
			<input type="submit" value="Add meal" name="ok-button">
		</form>	
	</body>
</html>