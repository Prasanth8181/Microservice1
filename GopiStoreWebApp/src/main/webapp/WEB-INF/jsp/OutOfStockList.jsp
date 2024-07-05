<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="AgentHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
tr:hover {background-color: #D6EEEE;}
table, th, td {
  border: 1px solid orange;
  border-collapse: collapse;
}
th, td {
 /*  background-color: #ffebe0; */
  background-color: white;
}
h3 {
	color: green;
}

</style>
<title>welcome</title>
</head>
<body>
<br/>
	<div align="center">
	<h3>Products gallery</h3>
	<table width:300% ;border="1";text-align:center" >
		<thead>
			<tr>
				<td align="center">Product Id</td>
				<td align="center">Product Name</td>
				<td align="center">Product Image</td>
				<td align="center">Product Price</td>
				<td align="center">Product Description</td>
				<td align="center">Click & Add To Stock</td>
			</tr>
		</thead>
		<c:forEach var="product" items="${products_list}">
			<tr>
				<td align="center">${product.prodId}</td>
				<td align="center">${product.prodName}</td>
				<%-- <td>src="/@{${product.photosImagePath}} --%>
				<td>
				<img src="data:image/jpeg;base64,${product.base64EncodeImage}" width="120" height="80" alt="No Image">
				</td>
				<td align="center">${product.prodPrice}</td>
				<td align="center">${product.prodDesc}</td>
				<td align="center"><a href="AddToStockFromOutOfStock?PoductID=${product.prodId}&ProductName=${product.prodName}"><input type="button" value="Add To Stock"/></a></td>
		</c:forEach>
		
		</tr>
	</table>
</div>
</body>
</html>