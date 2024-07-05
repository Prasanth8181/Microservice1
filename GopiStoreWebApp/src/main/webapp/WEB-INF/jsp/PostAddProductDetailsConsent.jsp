<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<%@ include file="AgentHeader.jsp"%>
<html>
<head>
<style type="text/css">
.box
{
  padding: 5px 20px;
  margin: 10px 10px;
  size: auto;
  border-color: orange;
  border-radius: 2px;
  /* text-transform: uppercase; */
  text-align: center;
  opacity: 0.8;   
}
input[type=submit]
{
  align-items:center;
  background-color:orange;
  border: 2px solid black;
  color: white;
  padding: 8px 16px;
  margin: 30px 50px;
  cursor: pointer;
}
input[type=image]
{
  align-items:center;
  background-color:orange;
  border: 2px solid black;
  color: white;
  padding: 8px 16px;
  margin: 30px 50px;
  cursor: pointer;
}
h4
{
  color:orange;
  text-shadow: 0.7px 0.7px black;
}
</style>

<meta charset="ISO-8859-1">
<title>Product Image</title>
</head>
<body>
<form:form action="postImageAdd" enctype="multipart/form-data" modelAttribute="productAddDTOobj" method="POST">
<h4 align="center"><b><i>UPLOAD PRODUCT IMAGE</i></b></h4>
		<div align="center">
			<label for="name">Product Name:
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				</label><form:input type="text" id="name" class="box" path="prodName" placeholder="Enter Product Name" readonly="true" /> <br /> 
				<label for="desc">Product Destcription: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:input type="text" id="desc" class="box" path="prodDesc" placeholder="Enter Product Description." readonly="true"/> <br />
				 <label for="price"> Price: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			</label><form:input type="number" id="price" class="box" path="prodPrice" placeholder="Enter price of the product." readonly="true"/> <br />
			<label for="category">Product Category : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:input type="text" id="prodCategory" class="box" path="prodCategory" readonly="true"/> <br />
			<br/>
		     <input type="submit" value="Back" class="submitFinal"/> <br />
			<hr>
		</div>
	</form:form>
</body>
</html>