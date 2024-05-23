<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.tap.userdaoimpl.RestaurantDaoImpl"%>
<%@page import="com.tap.model.Restaurant"%>
<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.model.Menu"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.userdaoimpl.MenuDaoImpl"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Menu</title>
<style>
body {
	margin: 0;
	padding: 0;
	background-image:url("backgrounds/neon2.png");
	background-position: center top;
	background-repeat: 1 	;
	background-size: cover;
}

.main-division {
	width: 80%;
	height: 700px;
	padding: 0;
	
	margin-left: 2cm;
	
}

.sub-division1 {
	width: 70%;
	display: flex;
	justify-content: center;
	align-content: center;
	text-align: center;
	margin-left: 5.7cm;
	padding: 0.2cm 0.2cm;
	border-radius: 10px;
	color: white;
}

.sub-division1 h2 {
	font-size: 40px;
}

.sub-division2 {
	display: flex;
	font-size: 15px;
	border: 3px solid black;
	border-radius: 10px;
	box-shadow: 0px 0px 8px 4px blue;
	width: 70%;
	margin-left: 5.7cm;
	font-weight: bolder;
	color: white;
		background: black;
	
}

.page
{
	display: flex;
	margin-left: -8cm;
}

.cart
{
	margin-top: 1.6cm;
}

.cart a
{
	border: 3px solid black;
	font-size: 20px;
	margin-top: 2cm;
	margin-left:-3cm;
	text-decoration: none;
	color: red;
	padding: 3px 8px;
	background: black;
	font-weight: bolder;
	box-shadow: 0px 0px 4px 8px yellow;
	
	
	
	
}

.cart1 a
{
	margin-right: 4cm;
}
.cart a:hover
{
	background: white;
	color: black;
}



#i1 {
	font-size: 30px;
	font-weight: bolder;
	color: maroon;
}

.mini-1 {
	width: 60%;
	margin-top: -3px;
	margin-left: 30px;
}

.mini-2 {
	margin-top: 7px;
	margin-bottom: 7px;
	width: 10%;
	border: 3px solid white;
	border-radius: 20px;
	margin-left: 5cm;
	text-align: center;
}

.mini-2 p img, .mini-3 p img {
	width: 15px;
	height: 15px;
	margin-right: 5px;
}

.sub-division3 {
	margin-left: 5.7cm;
	width: fit-content;
	
}
.sub-division3 h2	
{
border: 1px solid black;
	background: black;
	color: green;
	border-radius: 7px;
	padding: 4px 6px;	

}
.sub-division4{

width: auto;

}
.sub-division5 {
	width: 70%;
	margin-left: 5.7cm;
	margin-bottom: 10px;
	border: 3px solid black;
	display: flex;
	border-radius: 20px;
	box-shadow: 0px 0px 10px 6px maroon;
	color: white;
		background: black;
	
}
.sub-division4:hover
{
	transform: scale(1.1);
	 transition: transform 0.3s ease;
	 cursor: pointer;
}
.mini-3 {
	width: 75%;
	font-size: 15px;
	font-weight: bolder;
	margin-left: 20px;
	margin-top: 10px;
}

.mini-4 {
	width: 25%;
	margin-left: 6cm;
}

.mini-4 p img {
	border: 3px solid black;
	width: 125px;
	height: 125px;
	border-radius: 20px;
}

.b1 a, .b2 a {
	border: 3px solid white;
	padding:4px 5px;
	border-radius:6px;
	text-decoration: none;
	color: black;
	margin-left: 0.2cm;
	font-size: 17px;
	font-weight: bolder;
	color: white;
}

.b1 a:hover, .b2 a:hover {
	background: white;
	color: black;
	box-shadow: 0px 0px 6px 2px red;
}

.button {
	width: 200px;
	display: flex;
	justify-content: center;
	align-content: center;
	margin-bottom: 0.5cm;
	margin-left: -1cm;
	place-content: center;
}

.checkout {
	display: flex;
	border: 3px solid black;
	width: 20%;
	justify-content: center;
	margin-left: 15cm;
	flex: 1;
	font-size: 18px;
	font-weight: bolder;
	color: black;
	background: teal;
	box-shadow: 0px 0px 6px 5px black;
}

.checkout input {
	width: 100%;
	height: 100%;
	background: transparent;
	border: 0;
	outline: 0;
	font-size: 30px;
	cursor: pointer;
}

.checkout input:hover {
	background: black;
	color: white;
}
</style>

</head>
<body>

<% ArrayList<Menu> menu_list1 =(ArrayList<Menu>)request.getAttribute("menu-list"); 
List<Menu> list2=null; 
String name=null;
String address=null;
float ratings=0;


if(menu_list1 != null)
{
		RestaurantDaoImpl rs=new RestaurantDaoImpl();
		List<Restaurant> r =rs.getByRestaurantOwnerId(menu_list1);
		
		if(r.size()>0)
		{
			for(Restaurant resta:r)
			{
				 name = resta.getName();
				 address = resta.getAddress();
				 ratings = resta.getRatings();
			}
		}
	
}

%>




	<div class="main-division">
	
	<div class="page">
	
	
	<div class="sub-division1">
			<div>
				<h2>Welcome to <%=name %></h2>
			</div>
			
		</div>
		
		<div class="cart cart1">
			<a href="cart.jsp">Cart</a>
		</div>
		
		<div class="cart">
			<a href="homepage.jsp">Homepage</a>
		</div>
	
	</div>

		

		<div class="sub-division2">

			<div class="mini-1">
				<p id="i1"><%= name %></p>

				<pre><%=address %> 1.3km.
</pre>
			</div>

			<div class="mini-2">
				<p>
					<img src="menu-backgrounds/rating-image.png" alt="" /><%=ratings %>
				</p>
				<hr />
				<p>5.5k+ ratings</p>
			</div>

		</div>
		<div class="sub-division3">
			<div>
				<h2>Here are our top Items :</h2>
			</div>
		</div>






<%        ArrayList<Menu> menu_list =(ArrayList<Menu>)request.getAttribute("menu-list"); 
			List<Menu> list1=null;
			
			
		if(menu_list!=null)
		{
			MenuDaoImpl mdi = new MenuDaoImpl();
			list1=mdi.getbyId(menu_list);
			
			if(list1 != null)
			{
				for(Menu m : list1)
				{
					%>
					
					<div class="sub-division4">


		
			<div class="sub-division5">

				<div class="mini-3">

					<p>
						<img src="menu-backgrounds/nonveg.png" alt="" />
						<%=m.getName()%></p>
					<p>
						price:<%=m.getPrice()%></p>
					<p>
						Description:
						<%=m.getDescription()%></p>

				</div>

				<div class="mini-4">
					<p>
						<img src="<%=m.getImagepath()%>" alt="" />
					</p>

					<div class="button">

						<div class="b1">

							<a href="cart-servlet?id=<%=m.getMenuId()%>">Add to cart</a>


						</div>
						<div class="b2">

							<a href="call-paymentPage?id=<%=m.getMenuId()%>&price=<%= m.getPrice()%>">Buy Now</a>
							


						</div>



					</div>

				</div>
			</div>




			
		</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		<% 		}
			}
			
			
		}

%>


		

	</div>









</body>
</html>
