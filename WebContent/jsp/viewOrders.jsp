<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cart.dto.OrderItem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js"></script>  

<style>
fieldset {
	display: block;
	margin-left: 4px;
	margin-right: 5px;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 2.5px groove;
	width: 525px;
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
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<script src="js/bootstrap.min.js"></script>  

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
<div class="container-fluid">

	<form>
		<Table class=" table table-condensed">
			<tr>
				<td width="8%">
						<button class="mybuttonstyle"  type="submit" formaction="./UserHome.jsp">Home</button>
					</td>
				<td><button class="mybuttonstyle" align="right" type="submit"
						formaction="logoutservlet">LogOut</button></td>
			</tr>
		</Table>
	</form>

	<c:forEach var="order" items="${arrayOfOrders}">
		<fieldset>
			<table>	
				<%--  <c:out value="${temp}"/> --%>
				<%-- <td>${orderItem.orderid}</td> --%>
				<c:set var="temp" value="empty value" scope="session" />
				<c:forEach var="orderItem" items="${order}">
					<tr>
						<c:if test="${ orderItem.orderid!= temp }">
							<td>Order Date:</td>
							<td><b>${orderItem.orderDate}</b></td>
							<%-- </c:if> --%>
							<%-- <c:if test="${ orderItem.orderid!= temp }"> --%>
							<!-- <td>Total Price: $</td> -->
						</c:if>
					</tr>
					<br />
					<br />
					<c:if test="${ customerCart.orderid!= temp }">
						<c:set var="temp" value="${orderItem.orderid}" scope="session" />
					</c:if>
					<tr>
						<td><i>${orderItem.quantity} ${orderItem.productName}</i></td>
					</tr>
					<tr>
						<td><img src="${orderItem.image}" class="img-circle" width="100" height="100"></td>

						<td><b>${orderItem.productDesc}</b></td>
					</tr>
					<tr>
					<td> Price : $ ${orderItem.price}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		<br />
		<br />
	</c:forEach>
</div>
</body>
</html>