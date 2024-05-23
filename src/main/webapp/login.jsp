<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>login</title>

<style>
body {
	width: 100%;
	height: 100vh;
	display: flex;
	justify-content: center;
	margin-top: 7cm;
}

.t1 {
	font-size: 30px;
	margin-bottom: 10px;
}

span a {
	text-decoration: none;
	color: red;
}

.t2 {
	margin-bottom: 18px;
}

a {
	color: red;
	text-decoration: none;
}

.l1 label {
	font-size: 20px;
	width: 100px;
	display: inline-block;
}

.l1 input {
	padding: 10px 70px;
}

.l1 .s1 {
	padding: 10px 190px;
	background: orange;
	outline: 0;
	border: 0;
	cursor: pointer;
}
</style>
</head>
<body>

	
	<div class="d1">


		<div class="t1">Login</div>
		<div class="t2">
			<span>or <a href="signup.jsp">create an account</a></span>
		</div>


		<form action="callservlet4?type=click" method="get">

			<div class="l1">

				<label for="uname">Username</label> <input type="text"
					placeholder="Username" name="uname" required><br><br>
							<label for="pass">Password</label> <input type="password"
							placeholder="Password" name="pass" required><br><br>
										<input  class="s1" type="submit" value="login" name="submit">
			</div>

		</form>

	</div>

	

	





</body>
</html>