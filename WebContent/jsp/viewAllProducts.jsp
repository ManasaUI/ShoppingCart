<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cart.dto.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<<meta name="viewport" content="width=device-width">
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
div {
	background-color: Snow;
	width: 320px;
	padding: 10px;
	border: 3px solid gray;
	margin: 0;
}
</style>
<style type="text/css"> 
.mycartstyle{
	background: #90c324;
border: 2pxpx solid #666666;
color: #666666;
font-size: 12px;
padding: 4px 4px 4px 4px;
margin-left: 30px;

}
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



<ul>
<li><button class="mybuttonstyle" type="submit" formaction="ViewCartServlet">ViewCart</button></li>
<li><button  class="mybuttonstyle" type="submit" formaction="ViewOrderServlet">ViewOrders</button></li>
<li><button class="mybuttonstyle"  align="right" type="submit" formaction="logoutservlet">LogOut</button></li>
</ul><br>
</form>

	<form action="SearchProducts" method="get">
	
	<input align="right" type="text" name="stringtosearch"> <input type="submit"
			name="search" value="SearchProducts"><br><br>
			
			<button class="link" type="submit" name="operation" value="Viewproducts"  formaction="viewallproducts">View All Products</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="grocery" formaction="SearchCategoryServlet">Grocery</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="fashion" formaction="SearchCategoryServlet">Sports</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button  class="link" type="submit" name="operation" value="electronics" formaction="SearchCategoryServlet">Electronics</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="link" type="submit" name="operation" value="toys" formaction="SearchCategoryServlet">Toys</button>&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
				

	</form>

	<c:forEach var="product" items="${productList}">
		<form>
			<table width="50%" style="display: inline-block;" >
				<tr>
					<td colspan="2"><b>${product.productName}</b></td>
				</tr>

				<tr>
					<td><img src="${product.image}" class="img-rounded" width="100" height="100"></td>
					<td>${product.productDesc}</td>
					<td>
						<button class="mycartstyle" type="submit" name="AddtoCart"
							value="${product.productId}" formaction="addToCart">Add
							to Cart</button>
					</td>
				</tr>
				<tr>
					<td>price:$<b>${product.productPrice}</b></td>
					<td>quantity:<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
					</select></td>
				</tr>
			<br>
			<br>
			
			<HR>
			</table>
		</form>
	</c:forEach>


</body>

</html>