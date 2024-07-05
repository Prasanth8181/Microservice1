<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="AgentHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
select
{
  padding: 6px 60px;
  margin: 10px 6px;
  size: auto;
  border: 2px solid black;
  border-color: orange;
  border-radius: 2px;
  opacity: 0.8;   
}
input[type=file]
{
  padding: 6px 2px;
  margin: 10px -40px;
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
</style>

<title>Adding product</title>
</head>
<body>

	<h1 align="center">Adding New Product</h1>
	<form:form action="postUpdate" enctype="multipart/form-data" modelAttribute="productAddDTOobj" method="POST" >
		<div align="center">
			<label for="name">Product Name:
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				</label><form:input type="text" id="name" class="box" path="prodName" placeholder="Enter Product Name"/> <br /> 
				<label for="desc">Product Destcription: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:input type="text" id="desc" class="box" path="prodDesc" placeholder="Enter Product Description." /> <br />
				 <label for="price"> Price: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			</label><form:input type="number" id="price" class="box" path="prodPrice" placeholder="Enter price of the product." /> <br />
			<!-- product category -->
				<label for="category">Product Category : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:select id="category" name="prodCategory"  path="prodCategory" placeholder="Select product category">
				<form:option value="0">--Select--</form:option>
				<form:option  value="bangles">Bangles</form:option >
				<form:option  value="stationary">Stationary</form:option >
				<form:option  value="babycare">Baby Care</form:option >
				<form:option  value="toothcare">Tooth Care</form:option >
				<form:option  value="bodycare">Body Care</form:option >
				<form:option  value="haircare">Hair Care</form:option >
				<form:option  value="books">Books</form:option >
				<form:option  value="softdrinks">Soft Drinks</form:option >
				<form:option  value="cheppalsmale">Cheppals-Male</form:option >
				<form:option  value="cheppalsfemale">Cheppals-Female</form:option >
				<form:option  value="bodycare">Electrictical</form:option >
				<form:option  value="giftitems">Gift Items</form:option >
				<form:option  value="accessories">Accessories</form:option >
				
			</form:select>
				<br /> 
				<label for="img">Add Image Here: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<input name="image" type="file" accept="image/png, image/jpeg"></input>
				<!-- <label for="img">Add Image Here:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<input name="image" type="file" accept="image/png, image/jpeg"></input> -->
			    <br/>
				<!-- product category -->
		     <input type="submit" value="Submit" class="submitFinal"/> <br />
			<hr>
		</div>
	</form:form>
</body>
</html>