<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="AgentHeader.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
h2 {
	color: navy;
	border: 2px solid orange;

}
h3
{
	color: green;
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
</style>

<title>Consent Page</title>
</head>
<body>
	<h2 align="center"><i>consent page</i></h2>
	<form:form action="agent" method="GET">
		<div align="center">
			<h3>${responseDTO.productName} ${responseDTO.successMessage}</h3><br/>
		    <h3>${responseDTO.responseMessage}</h3><br/>
		     <input type="submit" value="Back" class="submitFinal"/> <br />
			<hr>
		</div>
	</form:form>
</body>
</html>