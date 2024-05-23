<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.List"%>
	<%@page import ="com.tap.model.Restaurant"%>
  	<%@ page import ="com.tap.userdaoimpl.RestaurantDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>try</title>
<style>

.c3
{
width: 100%;
height:auto;
background:red;
display: grid;
grid-template-columns:repeat(3,1fr);
grid-gap:20px;
place-items: center;


}
.l1
{
height: 15px;
width: 15px;
}

.s7
{
margin-top:1cm;
width: 290px;
height: 400px;
cursor: pointer;
background: black;
color:white;
text-align: center;
font-size: 15px;
border: 3px solid black;
border-radius:20px;
box-shadow: 0px 0px 4px 10px purple;
}

.s7 pre
{
	text-align: center;
}
.image1
{
width: 280px;
height: 250px;
border-radius: 20px;
padding: 5px 5px;
}


</style>
</head>
<body>




<h1>iam try.jsp</h1>
<%List<Restaurant> li = (List<Restaurant>)session.getAttribute("restaurants");%>
<div class="c3" >
<%if(li != null && li.size()>0)
{	
	for(Restaurant restaurant: li)
	{
	%>
	<div class="s7">
	
	<a href="callservlet3"><img class="image1" src="<%=restaurant.getImagePath() %>" alt="" /></a>
	<p>	<%=restaurant.getName() %></p>
	<pre><img class="l1" src="restaurant-images/l1.png" alt="" /> <%=restaurant.getRatings() %> - <%= restaurant.getEta() %></pre>
	<p><%=restaurant.getCuisineType() %><p>
	<p><%= restaurant.getAddress()%><p></p>
	
	</div>
	
	
	<%}
} %>
</div>








</body>
</html>