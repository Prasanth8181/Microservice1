<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">

/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
.topnav a.Products {
  background-color: #76a3a8;
  color: white;
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
.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: blink;
}
.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}
.dropdown {
	float: left;
	overflow: hidden;
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
<head>
<title>Products page &#128722;</title>
</head>
<body>
	<header>
		<marquee>Welcome to the gopi store, you can find all the
			produts which are available in our store</marquee>
		<h1 align="center">Gopi Store &#128722;</h1>
		<hr>
		<div class="topnav">
			<a class="active" href="welcome">Home</a>
			<div class="dropdown">
				<button class="dropbtn">
					Products<i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="productDisplay?productCategory=stationary">Stationary</a> 
					<a href="productDisplay?productCategory=cheppalsmale">Cheppals-Male</a>
					<a href="productDisplay?productCategory=cheppalsfemale">Cheppals-Female</a> 
					<a href="productDisplay?productCategory=toothcare">Tooth paste/Tooth Brushes</a>
					<a href="productDisplay?productCategory=bodycare">Body Care(Soaps,Powders)</a>
					<a href="productDisplay?productCategory=haircare">Hair Care(Shampoo,Colors)</a>
					<a href="productDisplay?productCategory=bangles">Bangles</a>
					<a href="productDisplay?productCategory=softdrinks">Soft Drinks</a>
					<a href="productDisplay?productCategory=electricalItems">Electrical Items</a>
					<a href="productDisplay?productCategory=books">Books</a>
					<a href="productDisplay?productCategory=babycare">Baby Care</a>
					<a href="productDisplay?productCategory=">Food (chocos,biscuits..etc)</a>
					<a href="productDisplay?productCategory=giftitems">Gift Items</a>
					<a href="productDisplay?productCategory=homeappliances">home appliances</a>
					<a href="productDisplay?productCategory=accessories">Fancy Accessories</a>
					
				</div>
			</div>
			<a href="news">News</a> 
			<a href="/ContactUs">Contact Us</a> 
			<a href="/agent">Agent</a>
		</div>

		<hr>
	</header>
</body>
</html>