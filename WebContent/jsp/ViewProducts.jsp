<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cart.dto.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
				<td><button class="mybuttonstyle" type="submit" formaction="AdminHome.jsp">Home</button></td>
				<td width="100%"><H1 align="center">
						<i>Welcome Administrator</i>
					</H1></td>
				<td><button class="mybuttonstyle" align="right" type="submit"
						formaction="logoutservlet">LogOut</button></td>

			</tr>
		</Table>
	</form>



	<c:forEach var="product" items="${productList}">
		<form>
			<table width="50%" style="display: inline-block;" >
				<tr>
					<td colspan="2"><b>${product.productName}</b></td>
				</tr>

				<tr>
					<td><img src="${product.image}" width="100" height="100"></td>
					<td>${product.productDesc}</td>
					
				</tr>
				<tr><td>price:$<b>${product.productPrice}</b></td></tr>
				
				<HR>
			</table>
		</form>
	</c:forEach>



</body>
</html>