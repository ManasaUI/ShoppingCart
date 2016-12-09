<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> -->

<style type="text/css"> 
.mybuttonstyle{
	
	border:1px solid #61c4ea;
	background-color:#7cdeee;
	color:#333;
	font-family:'Verdana',Arial,sans-serif;
	font-size:14px;
	padding:3px
}
</style>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Create Post</title>
</head>
<body bgcolor="#F0FFF0">
	<!-- bgcolor="#F5F5DC" -->
	<table>
		<tr>
			<td><img src="img1.jpg" height="100" width="660"></td>
			<td><img src="img2.jpg" height="100" width="660"></td>
		</tr></table><br>
		
		<form>
<Table>
<tr>
	<td><button class="mybuttonstyle" type="submit" formaction="AdminHome.jsp">Home</button></td>
<td width="100%"><H1 align="center"><i>Welcome Administrator</H1></td>
 <td><button  class="mybuttonstyle" align="right" type="submit" formaction="logoutservlet">LogOut</button></td>

</tr>
</Table>
</form>
<!-- </form>
		
			<input type="submit" value="Logout" /> <br /> 

		</form > -->
	<form action="createproduct" method="post">
		<table id="createpost">
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="productname"  required /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="10" cols="30" name="description" required /></textarea></td>
			</tr>
			
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" required /></textarea></td>
			</tr>
			
			<tr>
				<td>Upload Image</td>
				<td><input type="file" name="productupload" size="40" required/></td>
			</tr>
			<tr>
			<td>Category</td>
			<td>
		<select name="category">
		<option value="grocery">Grocery</option>
		<option value="clothing">Clothing</option>
		<option value="electronics">Electronics</option>
		<option value="sports">Sports</option>
		<option value="toys">Toys</option>
		</select>
		</td>				
			</tr>
			<tr>
				<td><input class="mybuttonstyle" type="submit" value="post product" /></td>

			</tr>

		</table>
	</form>

</body>
</html>