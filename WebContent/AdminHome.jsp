<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's Screen</title>
<style>
#nav2 {
     height: 30px;
	color:#333;
	font-family:'Verdana',Arial,sans-serif;
	font-size:14px;
	
}
</style>

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

</head>
<body bgcolor="#F0FFF0">
<table>
		<tr>
			<td><img src="img1.jpg" height="100" width="660"></td>
			<td><img src="img2.jpg" height="100" width="660"></td>
		</tr></table><br>

<form>
<Table>
<tr>
	<td><button type="submit" class="mybuttonstyle" formaction="AdminHome.jsp">Home</button></td>
<td width="100%"><H1   align="center"><i>Welcome Administrator</H1></td>
 <td><button class="mybuttonstyle"  align="right" type="submit" formaction="logoutservlet">LogOut</button></td>

</tr>
</Table>
</form>

<br><br/>

<div id="nav2"><center>
<a href="http://localhost:8081/ShoppingCart/createProduct.jsp">Create a new Product</a><br><br>
<form><button type="submit" name="operation" value="Viewproducts"  formaction="viewadminproducts">View All Products</button></form>
</center></div>
</body>
</html>