<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 --><title>Insert title here</title>
<style>
fieldset {
  border: thin solid white;

	margin: 1 auto;
	padding: 2em;
	width: 30%;
}

legend {
	font-weight: bold;
	float: left;
	margin-bottom: .5em;
	width: 80%;
}
</style>

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
<body>


</head>
<body bgcolor="#F0FFF0">


<form>
<Table>
<tr>
 <td width="8%"><H1 align="left"> <button class="mybuttonstyle" type="submit" formaction="UserHome.jsp">ViewCart</button></H1></td>
 <td width="100%"><H1 align="center"><i>welcome <%=(String)session.getAttribute("user")%></H1></td> 
 <td width="8%"><button  class="mybuttonstyle" type="submit" formaction="ViewOrderServlet">ViewOrders</button></td>
 <td><button class="mybuttonstyle" align="right" type="submit" formaction="logoutservlet">LogOut</button></td>
 </tr>
</Table>
</form>


<form action="PlaceOrderServlet" method="post">	
<fieldset>
		<LEGEND>
			<b>Card Details</b>
		</LEGEND>
		<table>

			<tr>
				<td>Card Type</td>
				<td><select style="border-radius: 4px" name="cardtype">

						<option value="VISA">VISA</option>
						<option value="MASTERCARD">MASTERCARD</option>
						<option value="DISCOVER">DISCOVER</option>						
						<option value="AMERICANEXPRESS">AMERICANEXPRESS</option>
				</select></td>
			</tr>
			<tr>
				<td>Name on Card</td>
				<td><input type="text" name="CardName" required></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="number" name="CardNumber" required></td>
			</tr>

			<tr>
				<td>Expiration Details</td>
				<td><select style="border-radius: 4px" name="month">
						<option value="1">January</option>
						<option value="2">February</option>
						<option value="3">March</option>
						<option value="4">April</option>
						<option value="5">May</option>
						<option value="6">June</option>
						<option value="7">July</option>
						<option value="8">August</option>
						<option value="9">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>

				</select> <select style="border-radius: 4px" name="year">
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2019">2018</option>
						<option value="2018">2019</option>
						<option value="2020">2020</option>


				</select></td>

			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="number" name="CVV" required></td>
			</tr>


		</table>
	<br><br>
	
	
		<LEGEND>
			<b>Billing Information</b>
		</LEGEND>
		<table>

			<tr>
				<td>Name</td>
				<td><input type="text" name="Name"  required></td>
			</tr>
			<tr>
				<td>Address line 1</td>
				<td><input type="text" name="Addressline1" required></td>
			</tr>
			<tr>
				<td>Address line 2</td>
				<td><input type="text" name="Addressline2"></td>
			</tr>

			
			<tr>
				<td>City</td>
				<td><input type="text" name="City" required></td>
			</tr>
			<tr>
				<td>State</td>
				<td>
				<select name="state">
	<option value="AL">AL</option>
	<option value="AK">AK</option>
	<option value="AZ">AZ</option>
	<option value="AR">AR</option>
	<option value="CA">CA</option>
	<option value="CO">CO</option>
	<option value="CT">CT</option>
	<option value="DE">DE</option>
	<option value="DC">DC</option>
	<option value="FL">FL</option>
	<option value="GA">GA</option>
	<option value="HI">HI</option>
	<option value="ID">ID</option>
	<option value="IL">IL</option>
	<option value="IN">IN</option>
	<option value="IA">IA</option>
	<option value="KS">KS</option>
	<option value="KY">KY</option>
	<option value="LA">LA</option>
	<option value="ME">ME</option>
	<option value="MD">MD</option>
	<option value="MA">MA</option>
	<option value="MI">MI</option>
	<option value="MN">MN</option>
	<option value="MS">MS</option>
	<option value="MO">MO</option>
	<option value="MT">MT</option>
	<option value="NE">NE</option>
	<option value="NV">NV</option>
	<option value="NH">NH</option>
	<option value="NJ">NJ</option>
	<option value="NM">NM</option>
	<option value="NY">NY</option>
	<option value="NC">NC</option>
	<option value="ND">ND</option>
	<option value="OH">OH</option>
	<option value="OK">OK</option>
	<option value="OR">OR</option>
	<option value="PA">PA</option>
	<option value="RI">RI</option>
	<option value="SC">SC</option>
	<option value="SD">SD</option>
	<option value="TN">TN</option>
	<option value="TX">TX</option>
	<option value="UT">UT</option>
	<option value="VT">VT</option>
	<option value="VA">VA</option>
	<option value="WA">WA</option>
	<option value="WV">WV</option>
	<option value="WI">WI</option>
	<option value="WY">WY</option>
</select>
				
				</td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="number" name="ZipCode" required></td>

			</tr>
			


		</table><br><br>
		
		<LEGEND>
			<b>Shipping Details</b>
		</LEGEND>
		<table>
		
		<tr>
				<td>Name</td>
				<td><input type="text" name="shippingName"  required></td>
			</tr>
			<tr>
				<td>Address line 1</td>
				<td><input type="text" name="Addresline1" required></td>
			</tr>
			<tr>
				<td>Address line 2</td>
				<td><input type="text" name="Addresline2"></td>
			</tr>

			
			<tr>
				<td>City</td>
				<td><input type="text" name="Cityname"  required></td>
			</tr>
			<tr>
				<td>State</td>
				<td>
				<select name="statename">
	<option value="AL">AL</option>
	<option value="AK">AK</option>
	<option value="AZ">AZ</option>
	<option value="AR">AR</option>
	<option value="CA">CA</option>
	<option value="CO">CO</option>
	<option value="CT">CT</option>
	<option value="DE">DE</option>
	<option value="DC">DC</option>
	<option value="FL">FL</option>
	<option value="GA">GA</option>
	<option value="HI">HI</option>
	<option value="ID">ID</option>
	<option value="IL">IL</option>
	<option value="IN">IN</option>
	<option value="IA">IA</option>
	<option value="KS">KS</option>
	<option value="KY">KY</option>
	<option value="LA">LA</option>
	<option value="ME">ME</option>
	<option value="MD">MD</option>
	<option value="MA">MA</option>
	<option value="MI">MI</option>
	<option value="MN">MN</option>
	<option value="MS">MS</option>
	<option value="MO">MO</option>
	<option value="MT">MT</option>
	<option value="NE">NE</option>
	<option value="NV">NV</option>
	<option value="NH">NH</option>
	<option value="NJ">NJ</option>
	<option value="NM">NM</option>
	<option value="NY">NY</option>
	<option value="NC">NC</option>
	<option value="ND">ND</option>
	<option value="OH">OH</option>
	<option value="OK">OK</option>
	<option value="OR">OR</option>
	<option value="PA">PA</option>
	<option value="RI">RI</option>
	<option value="SC">SC</option>
	<option value="SD">SD</option>
	<option value="TN">TN</option>
	<option value="TX">TX</option>
	<option value="UT">UT</option>
	<option value="VT">VT</option>
	<option value="VA">VA</option>
	<option value="WA">WA</option>
	<option value="WV">WV</option>
	<option value="WI">WI</option>
	<option value="WY">WY</option>
</select>
				
				</td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="number" name="Zip"  required></td>

			</tr>
			
	
		
		</table>
		
		<table>
			<tr>
			<td>
			<input class="mybuttonstyle" type="submit" name="placeorder" value="Place Order">
			</td></tr>
				
		<!-- 	<td><button class="mybuttonstyle" type="submit" formaction="./UserHome.jsp">Cancel Payment</button> </td>
	 -->		
			</table>
		
	
	</form>
</body>
</html>