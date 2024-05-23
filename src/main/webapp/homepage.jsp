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
<title>Homepage</title>
<style>

body{
width: 100%;
background-image: url("backgrounds/blacky.jpg");
background-position: center;
background-size: cover;




}

.new1
{
	width: 80%;
	margin-left: 4cm;
}

.c1
{
background:black;
color: white;

}


.header
{
	position: sticky;
	top: 0;
	left: 0;
	width: 100%;
}
 

.d1{
background: #d9cc0e ;
display: flex;
flex-direction: row;
box-shadow:4px 4px 10px black;
margin-bottom: 0.5cm;
border-radius : 20px;
position: sticky;
}


.d1{

width:100%;
height: 100px;

}

.s3
{
	color: teal;
}

.s1 img{
width: 80px;
height: 100px;
margin-top: -30px;
}

 
.s1 a{
text-decoration: none;
color: black;
font-size: 20px;
}
 
 
.d2{
width:30%;
display: flex;
flex-direction: row;
margin-top: 0.8cm;
justify-content: center;



}
.d3{
width:55%;
display: flex;
flex-direction: row;
margin-top: 0.8cm;
justify-content: flex-end;
}
.s1{
margin-right: 30px;
}

.d3{
display: flex;
flex-direction: row;
margin-right: 4cm;
}

.s2{
font-size: 20px;
margin-right: 20px;

}

.s2 a{
text-decoration: none;
color: black;
margin-bottom: -22px;

}

.s2 a img
{
	height: 20px;
	width: 20px;
}

.c1{
width: 100%;
height: 40vh;

display: flex;
flex-direction: column;
overflow-x:auto; 
box-shadow: 0px 0px 8px 3px maroon;
border-radius : 20px;

}

.s4 a img{
width: 150px;
height: 150px;
}
.s6 a img{
width: 200px;
height: 170px;
}

.s5{
display: flex;
flex-direction: row;
width: 200%;
}

.s5 , .c1,.c2{
margin-top: 1cm;
}

.s4 a,.s6 a{

margin-right: 1cm;
margin-left: 1cm;

}

.s4 a img{
border: 1px rigid black;
border-radius: 70px;
}

.s6 a img{
border: 1px rigid black;
border-radius: 20px;
}

.s4 h4,.s6 h4{

text-align: center;


}



.c1::-webkit-scrollbar{
width: 0;
}

.c3
{
width: 100%;
height:auto;
background:black;
display: grid;
grid-template-columns:repeat(3,1fr);
grid-gap:20px;
place-items: center;
border-radius: 20px;
box-shadow: 0px 0px 10px 4px maroon;


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
box-shadow: 0px 0px 10px 4px green;
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


<div class="new1">

<%String name = request.getParameter("uname"); 


%>	


<div class="header">

<div class="d1">

<div class="d2">
<div class="s1"><img src="images/tap-logo.png" alt="" /></div>
<div class="s1"><a href="#">others</a></div></div>

<div class="d3">
<div class="s2"> <a href="#">Search</a></div>
<div class="s2"> <a href="#">Offers</a></div>
<div class="s2"> <a href="#">Help</a></div>


<%if(name != null)
	{%>
<div class="s2"> <a href="#"> <img src="images/user.png" alt="" />  <%=name %></a></div>
<%}else{%>

<div class="s2"> <a href="login.jsp">Sign in</a></div>

<%} %>

	
	

<div class="s2"> <a href="cart.jsp">cart</a></div>
</div>

</div>

</div>

  
  
  

<div class="s3"><h2>What's on your mind?</h2></div>
<div class="c1">


<div class="s5">
<div class="s4"><a href="#"><img src="images/biryani.jpg" alt="" /><br /></a><h4>biryani</h4></div>
<div class="s4"><a href="#"><img src="images/burger.jpg" alt="" /><br /></a><h4>Burger</h4></div>
<div class="s4"><a href="#"><img src="images/pavbhaji.jpg" alt="" /><br /></a><h4>PavBhaji</h4></div>
<div class="s4"><a href="#"><img src="images/pizza.jpg" alt="" /><br /></a><h4>Pizza</h4></div>
<div class="s4"><a href="#"><img src="images/rolls.jpg" alt="" /><br /></a><h4>Rolls</h4></div>
<div class="s4"><a href="#"><img src="images/shawarma.jpg" alt="" /><br /></a><h4>Shawarma</h4></div>
<div class="s4"><a href="#"><img src="images/chapati.jpg" alt="" /><br /></a><h4>Chapati</h4></div>
<div class="s4"><a href="#"><img src="images/dal.jpg" alt="" /><br /></a><h4>Dal</h4></div>
<div class="s4"><a href="#"><img src="images/mushroomcurry.jpg" alt="" /><br /></a><h4>Mushroom Curry</h4></div>
<div class="s4"><a href="#"><img src="images/tomatocurry.jpg" alt="" /><br /></a><h4>Tomato Curry</h4></div>
<div class="s4"><a href="#"><img src="images/salad.jpg" alt="" /><br /></a><h4>Salad</h4></div>
<div class="s4"><a href="#"><img src="images/sushi.jpg" alt="" /><br /></a><h4>Sushi</h4></div>
<div class="s4"><a href="#"><img src="images/tacos.jpg" alt="" /><br /></a><h4>Tacos</h4></div>
<div class="s4"><a href="#"><img src="images/friedchicken.jpg" alt="" /><br /></a><h4>Fried Chicken</h4></div>
<div class="s4"><a href="#"><img src="images/rice.jpg" alt="" /><br /></a><h4>Rice</h4></div>
<div class="s4"><a href="#"><img src="images/cakes.jpg" alt="" /><br /></a><h4>Cakes</h4></div>
<div class="s4"><a href="#"><img src="images/ramen.jpg" alt="" /><br /></a><h4>Ramen</h4></div>
<div class="s4"><a href="#"><img src="images/noodles.jpg" alt="" /><br /></a><h4>Noodles</h4></div>
<div class="s4"><a href="#"><img src="images/fishfry.jpg" alt="" /><br /></a><h4>Fish</h4></div>
<div class="s4"><a href="#"><img src="images/frenchfries.jpg" alt="" /><br /></a><h4>French Fries</h4></div>
<div class="s4"><a href="#"><img src="images/panipuri.jpg" alt="" /><br /></a><h4>Panipuri</h4></div>
<div class="s4"><a href="#"><img src="images/lunch.jpg" alt="" /><br /></a><h4>Lunch</h4></div>


</div>
</div>


<div class="s3"><h2>Top Restaurant Chains In Banglore</h2></div>
<div class="c1">


<div class="s5">
<div class="s6"><a href="#"><img src="images/bbqnation.jpg" alt="" /><br /></a><h4>BBQ Nation</h4></div>
<div class="s6"><a href="#"><img src="images/biryanihouse.jpg" alt="" /><br /></a><h4>Biryani House</h4></div>
<div class="s6"><a href="#"><img src="images/dominos.jpg" alt="" /><br /></a><h4>Dominos</h4></div>
<div class="s6"><a href="#"><img src="images/heavenbakes.jpg" alt="" /><br /></a><h4>Heaven Bakes</h4></div>
<div class="s6"><a href="#"><img src="images/kfc.jpg" alt="" /><br /></a><h4>KFC</h4></div>
<div class="s6"><a href="#"><img src="images/mughal.jpg" alt="" /><br /></a><h4>Mughal</h4></div>
<div class="s6"><a href="#"><img src="images/munichinese.jpg" alt="" /><br /></a><h4>Muni Chinese</h4></div>
<div class="s6"><a href="#"><img src="images/nehdirestaurant.jpg" alt="" /><br /></a><h4>Nehdi Restaurant</h4></div>
<div class="s6"><a href="#"><img src="images/popeyes.jpg" alt="" /><br /></a><h4>Mushroom Popeyes</h4></div>
<div class="s6"><a href="#"><img src="images/royalhouse.jpg" alt="" /><br /></a><h4>Tomato Royal House</h4></div>
<div class="s6"><a href="#"><img src="images/starbucks.jpg" alt="" /><br /></a><h4>Starbucks</h4></div>
<div class="s6"><a href="#"><img src="images/sushirestaurant.jpg" alt="" /><br /></a><h4>Sushi Restaurant</h4></div>
<div class="s6"><a href="#"><img src="images/tacobell.jpg" alt="" /><br /></a><h4>TacoBell</h4></div>
<div class="s6"><a href="#"><img src="images/bar.jpg" alt="" /><br /></a><h4>Bar</h4></div>
</div>
</div>


<div class="s3"><h2>Restaurants with online food delivery in Bangalore</h2></div>




<div class="c3" >
<%List<Restaurant> li = (List<Restaurant>)request.getAttribute("restaurants");%>
<%if(li != null && li.size()>0)
{	
	for(Restaurant restaurant: li)
	{
	%>
	<div class="s7">
	
		<a href="callservlet3?id=<%=restaurant.getRestaurantId()%>&Rid=<%= restaurant.getRestaurantOwnerId()%>"><img class="image1" src="<%=restaurant.getImagePath() %>" alt="" /></a>
	
	<p>	<%=restaurant.getName() %></p>
	<pre><img class="l1" src="restaurant-images/l1.png" alt="" /> <%=restaurant.getRatings() %> - <%= restaurant.getEta() %></pre>
	<p><%=restaurant.getCuisineType() %><p>
	<p><%= restaurant.getAddress()%><p></p>
	
	</div>
	
	<%}
}else{ %>

<% response.sendRedirect("callservlet1"); %>

<%}
%>




</div>





</div>


</body>
</html>