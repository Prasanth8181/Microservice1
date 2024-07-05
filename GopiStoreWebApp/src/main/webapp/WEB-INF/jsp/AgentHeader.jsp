<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
h1
{
  color:orange;
  text-shadow: 0.7px 0.7px black;
}
marquee {
	color: green;
}
.navbar {
	overflow: hidden;
	background-color: #333;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: blink;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}
.topnav a.active {
  background-color: green;
  color: white;
}
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<marquee>welcome to the gopi store, you can find all the
	produts which are available in our store</marquee>
<h1 align="center">Gopi Store Agent &#128722;</h1>
<hr>
<body style="background-color: white;">
	<div class="navbar">
		<a href="/agent">Agent Home</a>
		<a class="active" href="welcome">Customer home page</a>
		<a href="#home">Documents</a>
		<div class="dropdown">
			<button class="dropbtn">
				Add/Update/Delete products <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="AddProduct">Add Product</a> 
				<a href="UpdateProductsList">Update/Delete/Out Of Stock products</a>
				<a href="outOfStockModules">Out Of Stock Product list</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Other services &nbsp <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="Reports">Reports</a> 
			</div>
		</div>
	</div>
<!-- </br>
	<p>Hi gopi chennuri, Hope you are doing well.</p>
	<p>Hope you feel great by using the agent services</p>
	<p>Incase of any queries kindly share your comments in the reports menu.</p>
    <p><i>-prasanth chennuri</i></p> -->
</body>
</html>

