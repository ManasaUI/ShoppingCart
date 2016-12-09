<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>User Home Page</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js"></script>  
<style>
button.link {
     background:none!important;
     border:none; 
     padding:0!important;
     font: inherit;
     border-bottom:1px solid #444; 
 
}


li {
list-style: none;
display: inline;
}
.mybuttonstyle{
height: 30px;
margin-left: 220px;
	Width: 150px;
	border:1px solid #61c4ea;
	background-color:#7cdeee;
	color:#333;
	font-family:'Verdana',Arial,sans-serif;
	font-size:14px;
	padding:5px
}
</style>

</head>

<body bgcolor="#F0FFF0">
<table>
		<tr>
			<td><img src="img1.jpg" height="100" width="660"></td>
			<td><img src="img2.jpg" height="100" width="660"></td>
		</tr></table><br>
		
	<h1 align="center">Welcome TO Online Shopping Cart</h1>
	<h2 ><font aligh=right color="pink"><i>welcome <%=(String)session.getAttribute("user")%>...!!</i></font></h2>
	<form>


<div id="nav">
<ul>
<li><button class="mybuttonstyle" type="submit" formaction="ViewCartServlet">ViewCart</button></li>
<li><button  class="mybuttonstyle" type="submit" formaction="ViewOrderServlet">ViewOrders</button></li>
<li><button class="mybuttonstyle"  align="right" type="submit" formaction="logoutservlet">LogOut</button></li>
</ul></div><br>
</form>


	<form action="SearchProducts" method="get">
		<input type="text" name="stringtosearch"> <input type="submit" name="search" value="SearchProducts"><br><br>
			<button class="link" type="submit" name="operation" value="Viewproducts"  formaction="viewallproducts">View All Products</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="grocery" formaction="SearchCategoryServlet">Grocery</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="fashion" formaction="SearchCategoryServlet">Sports</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="electronics" formaction="SearchCategoryServlet">Electronics</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="toys" formaction="SearchCategoryServlet">Toys</button>&nbsp;&nbsp;&nbsp;&nbsp;
	
			</form>
			

<!-- <footer>
<p>&copy; 2015 MiniMart Online Shopping Cart. All rights reserved.</p>
</footer> -->
	
</body>
</html>