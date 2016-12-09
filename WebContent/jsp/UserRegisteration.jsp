<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Registeration form</title>
</head>

<body bgcolor="#F0FFF0">
<table>
		<tr>
			<td><img src="img1.jpg" height="100" width="660"></td>
			<td><img src="img2.jpg" height="100" width="660"></td>
		</tr>
		<tr>
			<td colspan="2">
				<hr style="width: 250%" size="3" noshade="noshade">
				<h1 align="center">Welcome TO Online Shopping Cart</h1>
			</td>
		</tr>
	</table>
	<br>
	<form action="../createuser" method="post">
		<fieldset>
		<table> 
			<tr>
				<th><center>Hello User...!! Well come to Registration.</center></th>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="UserName" autofocus required></td>
			</tr>
			<tr>
				<td>First name:</td>
				<td><input type="text" name="FirstName" required></td>
			</tr>

			<tr>
				<td>Last name:</td>
				<td><input type="text"  name="LastName" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password"  name="Password"  minlength="10" required></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name="address" rows="6" cols="20" required></textarea></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="number" name="Phone" maxlength="10" required></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><input type="email" name="Email"  required></td>
			</tr>
			<tr>
				<td><input type="submit" name="Register" value="Register"></td>
				<td><input type="reset" name="Reset"></td>
			</tr>

		</table>
		</fieldset>
	</form>

</body>
</html>