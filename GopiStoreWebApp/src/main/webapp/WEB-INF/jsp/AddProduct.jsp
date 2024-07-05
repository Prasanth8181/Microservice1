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
  border: 2px solid #c842f5;
  color: white;
  padding: 8px 16px;
  margin: 30px 50px;
  cursor: auto;
}
input:focus {
	box-shadow: 0 0 8px #c842f5;
}
</style>
<script type="text/javascript">

	function validate() 
	{
		
		var productName=document.getElementById("name").value;
		var productDescription=document.getElementById("desc").value;
		var productPrice=document.getElementById("price").value;
		var productCategory=document.getElementById("category").value;
		if(productName=="")
		{
			alert("Product name can not be empty");
			return false;
		}
		else if(productDescription=="")
		{
			alert("Product description can not be empty");
			return false;
		}
		else if(productPrice==0)
		{
			alert("Product price can not be 0");
			return false;
		}
		else if(productCategory==0)
		{
			alert("Product select category ");
			return false;
		}
	}
</script>
<title>Adding product</title>
</head>
<body>
	<h1 align="center">Adding New Product</h1>
	<form:form action="PostAddProduct" enctype="multipart/form-data" modelAttribute="productAddDTOobj" method="POST" onsubmit="return validate()">
		<div align="center">
			<label for="name">Product Name:
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				</label><form:input type="text" id="name" class="box" path="prodName" placeholder="Enter Product Name" /> <br /> 
				<label for="desc">Product Destcription: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:input type="text" id="desc" class="box" path="prodDesc" placeholder="Enter Product Description." /> <br />
				 <label for="price"> Price: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			</label><form:input type="number" id="price" class="box" path="prodPrice" placeholder="Enter price of the product." /> <br />
			<!-- product category -->
				<label for="category">Product Category : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<form:select id="category" name="prodCategory"  path="prodCategory" placeholder="Select product category">
				<option value="0">--Select--</option>
				<option value="bangles">Bangles</option>
				<option value="stationary">Stationary</option>
				<option value="babycare">Baby Care</option>
				<option value="toothcare">Tooth Care</option>
				<option value="bodycare">Body Care</option>
				<option value="haircare">Hair Care</option>
				<option value="books">Books</option>
				<option value="softdrinks">Soft Drinks</option>
				<option value="cheppalsmale">Cheppals-Male</option>
				<option value="cheppalsfemale">Cheppals-Female</option>
				<option value="electricalItems">Electrictical</option>
				<option value="giftitems">Gift Items</option>
				<<option value="homeappliances">home appliances</option>
				<option value="accessories">Accessories</option>
				
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