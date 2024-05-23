<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.tap.userdaoimpl.MenuDaoImpl" %>
    <%@ page import="com.tap.model.Menu" %>
    <%@ page import="com.tap.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>cart</title>

<style>

body
{
	display:flex;
		justify-content:center;
		background: gray;
}

.main-grid
	{
		width:1200px;
		
		display: grid;
		
		grid-template-columns:700px 500px;
		
		column-gap:20px;	
	}
	
	.sub-grid1
	{
	height:500px;
	display: grid;
	grid-template-rows:200px 125px 125px;
	row-gap:50px;
	}
	
	.mini-grid1,.mini-grid2,.mini-grid3
	{
	border: 3px solid black;
	background: teal;
	margin-top: 5cm;
	
	}
	
	.mini-grid1 img
	{
	
		width: 120px;
		height: 120px;
		margin-top:2cm;
		margin-left: 3.5cm;
		margin-right: 1cm;
	}
	
	.mini-grid1
	{
		display: flex;
		align-self: center;
	}
	
	.p1,.p3,.p4
	{
	font-size: 25px;
	font-weight: bolder;
		margin-left: 0.5cm;
	}
	
	.p2
	{
	font-size: 15px;
	font-weight: normal;
		margin-left: 0.5cm;
	}
	
	.mini-grid2 
	{
	display: flex;
		align-self: center;
	}

	.mini-grid3 
	{
	display: flex;
		align-self: center;
	}
	.milli-grid1
	{
		display: grid;
		grid-template-columns:1fr 1fr;
		column-gap:20px;
		margin-left: 1cm;
	}
	.c1
	{
		border: 3px solid black;
		margin-bottom: 0.5cm;
	}
	
	.p5,.p7
	{
		font-size: 23px;
		font-weight: bolder;
		margin-left: 0.3cm;
	}
	
	.p6 a,.p8 a
	{
		text-decoration: none;
		font-size: 17px;
		color: black;
		margin-left: 1.5cm;
	}
	
	.p7
	{
		margin-top: 1cm;
	}
	
	.sub-grid2
	{	
		border: 5px solid black;
		box-shadow:0px 0px 15px 5px black;
		margin-top: 1.258cm;
		display: grid;
		grid-template-rows:repeat(5,1fr);
		grid-gap:20px;
		height: 750px;
		
	}
	.sub-grid2 img
	{
			width: 150px;
			height: 150px;
		}
	
	
	.details1,.details2,.details3,.details4,.details5
	{
	
		background: teal;
	}
	.details1 img
	{
	
		width: 100px;
		height:100px;
		margin-top: 0.5cm;
	}
	.details1 p
	{
	
		font-size: 25px;
		margin-top: 5cm;
	}
	.details1
	{
		
		height:300px;
		overflow: scroll;
		border: 3px solid black;
		margin: 5px 5px;
		box-shadow: 0px 0px 10px 6px yellow;
				border-radius: 10px;
		
		
	}
	
	table
	{
		border-collapse: collapse;
	}
	th ,tr, td
	{
		border: 3px solid black;
		width: 160px;
		text-align: center;
	}
	td img
	{
		margin-bottom: 10px;
	}
	.scroll
	{

	width: 100%;
	display: flex;
	place-content:space-around;
	border: 3px solid black;
	}
	
	.header
	{
		display: flex;
		justify-content: space-around;
		position: fixed;
	}
	.quantity
	{
		display: flex;
		width: 100%;
		height:100px;
		place-content:center;
		border: 0;
		outline: 0;
	}
	td.quantity input{
	
		width:40px;
		background: black;
		color: white;
		}
	td.quantity a{
	
		width:40px;
		height:30px;
		background: green;
		color: white;
		text-decoration: none;
		
		}
	
	.details2
	{
		font-size: 20px;
		overflow: scroll;
		height: 250px;
		border: 3px solid black;
		margin: 5px 5px;
		border-radius: 10px;
	}
	.details2::-webkit-scrollbar,.details1::-webkit-scrollbar{
	
	display: none;
	}
	
	.details2 table
	{
		width: 100%;
	}
	
	.details2 tr
	{
		height: 50px;
	}
	
	.d1
	{
		background: green;
		color: white;
		border-right: 0;
	}
	
	.d2
	{
		border-left:0;
		color: maroon;
		background: green;
		font-weight: bolder;
	}
	
	.items
	{
		width: 100%;
		text-align: center;
		background: green;
		
	}
	
	
	.items a 
	{
		text-decoration: none;
		font-size: 18px; 
		color: white;
		
	}
	
	.items:hover
	{
		background: navy;
		
	}
	
	.details3
	{
		height: 50px;
		display: flex;
		place-content:center;
		border: 3px solid black;
		margin: 5px 10px;
		box-shadow: 0px 0px 14px 4px red;
		
				
	}
	
	.details3 a
	{
		text-decoration: none;
		align-self: center;
		font-size: 25px;
		color: black;
		font-weight: bolder;
	}
	.details3:hover
	{
	
		height: 55px;
		width: 100%;
		justify-self:center;
		background: green;
		color: black;
		transition:ease 0.25s;
		
				
	}

</style>
</head>
<body>


<div class="main-grid">

<div class="sub-grid1" > 

<div class="mini-grid1">
<div>
<p class="p1">Account</p>
<p class="p2">To place your order now, log in to your existing account or sign up.</p>
<div class="milli-grid1">
	<div class="c1"><p class="p5">Already Have An Account?</p>
					<p class="p6"><a href="#">Sign in</a></p></div>
					
	<div class="c1"><p class="p7">New to swiggy?</p>
					<p class="p8"><a href="#">Sign in</a></p></div>
</div>
</div>
<div>
<a href="#"><img src="menu-items/login.png" alt="" /></a>
</div>
</div>

<div class="mini-grid2"><p class="p3">Delivery Address</p></div>
<div class="mini-grid3"><p class="p4">Payment</p></div>

</div>

<%ArrayList<cart> li =(ArrayList<cart>)session.getAttribute("cart-list"); 
List<cart> cart1 = null; %>
<div class="sub-grid2 ">




<div class="details1">
<div class="items"><a href="callservlet3">Add more Items</a></div>
<table>
					<th>Image</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>

<%

if(li != null)
{
	MenuDaoImpl mdi=new MenuDaoImpl();
	cart1=mdi.getCartItems(li);
	
	if(cart1.size()>0 && cart1 != null)
	{
		for(cart ca: cart1)
		{
			%>
			<div class="scroll">
			
					
					
					
					<tr>
					<td><img src="<%=ca.getImagepath() %>" alt="" /></td>
					<td><%=ca.getName() %></td>
					<td><%=((ca.getPrice())/ca.getQuantity())%></td>
					
					<td class="quantity">
					
					<a href="callquantity?action=inc&id=<%= ca.getMenuId()%>">+</a>
					<input type="text" value="<%= ca.getQuantity() %>"  />
					<a href="callquantity?action=dec&id=<%= ca.getMenuId()%>">-</a>
					
					
					</td>
					</tr>
					
					
					
				 	
			
<%}
		}
		}%>
		</div>	
		
		
		
		
		
		





</table>
 </div >
 <%int price=0; %>
 
 
 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					

	
<div class="details1 details2">

<table>

<th>Name</th>
<th>Total Price</th>


<%if(cart1.size()>0)
	{%>
 <%for(cart cs:cart1)
	{	%>
	
	
	<tr>
	
	<td><%= cs.getName() %> </td>
		<td><%= cs.getPrice() %>/-</td>
		<% price=price+cs.getPrice(); %>
		
	
	</tr>
	
	
	
	
	
			
	
	 
 <%}%>
	<tr >
		<td class="d1">The grand total is</td>
		<td class="d2"><%=price %>/-</td>
	</tr>
 <%}%>
 
 
 
	

 </table>
</div>
	
	
<div class="details3"> <a href="call-paymentPage?price=<%= price%>">Proceed to pay</a></div>


</div>

</body>
</html>
