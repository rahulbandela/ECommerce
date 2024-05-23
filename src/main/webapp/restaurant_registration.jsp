<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register Restaurants</title>
<style>

body{
background: teal;
}


.d1 {
display: flex;
flex-direction: column;
width: 100%;
margin-top: 5cm;
}

.c1{
font-size: 40px;
font-weight:bolder;
display:flex;
justify-content: center;
margin-bottom: 1cm;
border: 3px ridge black;
width: 15cm;
margin-left: 11cm;

}

.m1{
display: flex;
flex-direction: column;

}

.s1{
display: flex;
justify-content: center;
margin-bottom: 5px;
}

.s1 label{
width: 150px;
font-size: 20px;
font-weight: bold;


}

.s1 input{
padding: 6px 80px;
border-radius: 10px;
box-shadow: 0px 4px 8px purple;
}

.s2 input{

padding: 8px 180px;
background: orange;
margin-left:13cm;
margin-top:1cm;
border: 0;
outline: 0;
}




</style>


</head>
<body>


<diV class="d1">


<div class= "c1">Enter The Restaurants Details</div>


<div class="m1">
<form action="registration Success">



<div class="s1">
<label for="name">Name</label>
<input type="text" name="name" placeholder="Enter Restaurant Name"><br>
</div>

<div class="s1">
<label for="eta">ETA</label>
<input type="text" name="eta" placeholder="Enter Estimates Arrival Time">

</div>

<div class="s1">

<label for="cuisinetype">Cuisine Type</label>
<input type="text" name="cuisinetype" placeholder="Enter Cuisine Type">
</div>

<div class="s1">
<label for="address">Address</label>
<input type="text" name="address" placeholder="Enter the Address">

</div>

<div class="s1">
<label for="isactive">Is Active</label>
<input type="text" name="isactive" placeholder="Enter Active Status">

</div>

<div class="s1">
<label for="restaurantownerid">Restaurant Owner Id</label>
<input type="number" name="restaurantownerid" placeholder="Enter Your ID">


</div>

<div  class="s2">
<input type="submit" value="Register"></div>

</form>
</div>







</diV>

</body>
</html>