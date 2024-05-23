<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.tap.model.*" %>
     <%@ page import="com.tap.userdaoimpl.MenuDaoImpl" %>
    <%@ page import="com.tap.model.Menu" %>
    <%@ page import="com.tap.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Payment Page</title>


<style>
body {
	height: 100vh;
	display: flex;
	justify-content: center;
}

.main-div {
	width: 505px;
	height: 1000px;
	background: aqua;
	align-self: center;
	white-space: nowrap;
	margin-top: 6cm;
}

.main-div h2 {
	margin-top:0.5cm;
	text-align: center;
	font-family: cursive;
}

.credit-card {
	background: red;
	text-align: center;
	border: 3px solid black;
	cursor: pointer;
	width: 99%;
	margin-bottom: 1cm;
	
}

.credit-card0
{
	margin-top:2cm;
}

.credit-card p {
	font-size: 20px;
}
.credit-card img {
	width: 30px;
	height: 30px;
	
	
}


.hide {
	display: none;
	width: 100%;
	height: 100px;
	position: relative;
	text-align: left;
}

.hide label {
	font-size: 20px;
	width: 200px;
	display: inline-block;
	text-align: right;
	margin-top: 15px;
}

.hide input {
	width: auto;
	height: 25px;
}

.hide1 label{
	font-size: 20px;
}
.hide1 input{
	width: auto;
	height: 25px;
}

.credit-card:hover .hide {
	display: block;
}

.credit-card:hover {
	height: 220px;
}
.credit-card1:hover {
	height: 220px;
}
.credit-card2:hover {
	height: 400px;
}
.credit-card3:hover {
	height: 400px;
}

.upi
{
	display: none;
	background: teal;
}

.upi div
{
	border: 3px solid black;
	margin-top: 3.3px;
	
}
.credit-card:hover .upi
{
	display: block;
}

.hide1

{

	display: none;
	margin-bottom: 10px;
	
}

.upi div:hover .hide1
{
	display: block;
}

.hide
{
	margin-bottom: 20px;
}

.hide input::placeholder,.hide1 input::placeholder
{
	text-align: center;
}

.paynow
{
	border: 3px solid black;
	height: 35px;
	display: flex;
	justify-content: center;
	cursor: pointer;
	
}
.paynow a
{	
	text-decoration: none;
	font-size: 20px;
	color: black;
	cursor: pointer;
	align-self: center;
}
.paynow:hover
{
	background: green;
	color: red;
	
}





</style>
</head>
<body>
<% int pr=0; %>
<%ArrayList<cart> li =(ArrayList<cart>)session.getAttribute("cart-list"); 


if(li!=null)
{
	if(li != null)
	{
		
		for(cart l : li)
		{
			pr =l.getPrice();
		}
	}
}



%>





	<div class="main-div">
	
	


		<h2>Payment Page</h2>
		<h2>The total price is <%=pr %></h2>

		<div class="credit-card credit-card0">

			<img src="payment-images/credit-card.png" alt="" />
			<p>Credit Card</p>


			<div>

				<form class="hide">



					<label for="creditcard">Credit Card Number</label> <input
						type="number" placeholder="1234-1234-1234-1234" name="creditcard" /><br />
					<label for="expirydate">Valid Up to</label> <input type="date"
						value="mm/yy" name="expirydate" /><br /> <label for="cvv">Enter
						CVV</label> <input type="number" placeholder="123" name="cvv" />
						<input type="submit" />


				</form>
			</div>
		</div>

		<div class="credit-card credit-card1">

			
			<img src="payment-images/debit-card.png" alt="" />
			<p>Debit Card</p>
			



			<div>

				<form class="hide">



					<label for="debitcard">Debit Card Number</label> <input
						type="number" placeholder="1234-1234-1234-1234" name="debitcard" /><br />
					<label for="expirydate">Valid Up to</label> <input type="date"
						placeholder="mm/yy" name="expirydate" /><br /> <label for="cvv">Enter
						CVV</label> <input type="number" placeholder="123" name="cvv" />
						<input type="submit" />


				</form>
			</div>


		</div>
		
		
		<div class="credit-card credit-card2">
		

			
			<img src="payment-images/wallet.png" alt="" />
			<p>UPI</p>
			
			
			<div class="upi">
			<div class="phonepe">
			
			<img src="payment-images/phonepe-logo-icon.png" alt="" />
			<p>Phonepe</p>

					<form class="hide1">



						<label for="upi">UPI Id</label> <input type="text"
							placeholder="*********@ybl" name="upi" /><br />
							<input type="submit" />



					</form>

				</div>
			<div class="paytm">
			
			<img src="payment-images/paytm.png" alt="" />
			<p>Paytm</p>
			
				<form class="hide1">



						<label for="upi">UPI Id</label> <input type="text"
							placeholder="*********@paytm" name="upi" /><br />
							<input type="submit" />


					</form>
				
			</div>
			<div class="Gpay">
			
			<img src="payment-images/google-pay.png" alt="" />
			<p>Gpay</p>
			
				<form class="hide1">



						<label for="upi">UPI Id</label> <input type="text"
							placeholder="Alex123@icici" name="upi" /><br />
							<input type="submit" />



					</form>
				
			
			</div>
			
			</div>
			



			<div>

				
			</div>


		</div>
		
		
		
		
		<div class="credit-card credit-card3">
		

			
			<img src="payment-images/wallet.png" alt="" />
			<p>Wallets</p>
			
			
			<div class="upi">
			<div class="phonepe">
			
			<img src="payment-images/phonepe-logo-icon.png" alt="" />
			<p>Phonepe Wallet</p>

					<form class="hide1">



						<label for="phonepaynumber">Phonepe Number</label> <input type="number"
							placeholder="9876543219" name="phonepaynumber" /><br />
							<input type="submit" />



					</form>

				</div>
			<div class="paytm">
			
			<img src="payment-images/paytm.png" alt="" />
			<p>Paytm Wallet</p>
			
				<form class="hide1">



						<label for="paytmnumber">Paytm Number</label> <input type="number"
							placeholder="9876543218" name="paytmnumber" /><br />
							<input type="submit" />



					</form>
				
			</div>
			<div class="Gpay">
			
			<img src="payment-images/google-pay.png" alt="" />
			<p>Gpay Wallet</p>
			
				<form class="hide1">



						<label for="gpaynumber">Gpay Number</label> <input type="number"
							placeholder="Alex123@icici" name="gpaynumber" /><br />
							<input type="submit" />



					</form>
				
			
			</div>
			
			</div>
			



			<div>

				
			</div>
			
			

		</div>
		
		
		<div class="paynow">
				
				<a href="paymentSuccess.jsp"> pay <%=pr%> now</a>
				
			</div>
		
	</div>
		
		
		
		 
</body>
</html>



 