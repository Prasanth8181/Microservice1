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
<title>Product Modules</title>
</head>
<body>

	<div align="center">
	<h3><i>Products Modules</i></h3>
	<table width:300% ;border="1";text-align:center" >
		<thead>
			<tr>
				<td align="center">Product value</td>
				<td align="center">Product Display Name</td>
				<td align="center">Go to</td>
				
			</tr>
		</thead>
		<c:forEach var="list" items="${Product_categories_list}">
			<tr style="height: 40px">
				<td style="width: 15%" align="center">${list.categoryValue}</td>
				<td style="width: 35%" align="center">${list.categoryDisplayName}</td>
				<td style="width: 35%" align="center"><a href="postProductCategoriesModulePage?PoductCategory=${list.categoryValue}"><input type="button" value="Update/Delete/OutOfStock"/></a></td>
		</c:forEach>
		
		</tr>
	</table>
	
</div>
</body>
</html>