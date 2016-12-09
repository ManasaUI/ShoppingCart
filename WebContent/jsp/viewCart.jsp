<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.cart.dto.CustomerCart"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js"></script>  
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

<style>




p.padding{
    padding-left: 60%;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<form>
		<!-- <Table class=" table table-striped"> -->
		<Table class=" table table-condensed">
			<tr>
				<td width="8%">
						<button class="mybuttonstyle" type="submit" formaction="./UserHome.jsp">Home</button>
					</td>
		
				<td width="8%">
						<button class="mybuttonstyle" type="submit" formaction="ViewOrderServlet">ViewOrders</button>
					</td>
				<td><button class="mybuttonstyle"  type="submit"
						formaction="logoutservlet">LogOut</button></td>
			</tr>
		</Table>
	</form>

	<table border=1>
		<tr>
		
					<th align="left">Product name</th>
			<th  align="left" >Product Description</th>	
			<th align="left">image</th>
			<th align="left">Quantity</th>
			<th align="left">Total Price</th>
		</tr>

		<c:forEach var="customerCart" items="${customerOrderCart}"><tr>
				
				<td>${customerCart.product_name}</td>
				<td>${customerCart.product_desc}</td>
				<td><img src="${customerCart.image}" width="60" height="60"></td>
				<form>
			    <td><Select name="quantity">
						<c:forEach begin="1" end="10" var="val">


							<c:if test="${ customerCart.quantity!= val}">
								<option value="${val}">${val}</option>
							</c:if>
						<c:if test="${ customerCart.quantity== val}">	
						<option selected="selected" value="${customerCart.quantity}">${customerCart.quantity}</option>
						</c:if>
						</c:forEach>
						
				</Select><br>
					
						<button class="mybuttonstyle" type="submit" name="update"
							value="${customerCart.product_id}" formaction="updateCartItem">Update
						</button>
						
					
						<button class="mybuttonstyle" type="submit" name="delete"
							value="${customerCart.product_id}" formaction="deleteCartItem">Delete
						</button>
					</td>
					</form>

				<td>$ ${customerCart.price}</td>
			</tr>
			
			
		
		</c:forEach>
	</table>
	
	<p>Total Price $<b> <%= request.getAttribute("totalprice")%></b></p>
	
<form>
	<button class="mybuttonstyle" type="submit" formaction="./PaymentInfo.jsp">Proceed to CheckOut</button>
</form>

</body>
</html>