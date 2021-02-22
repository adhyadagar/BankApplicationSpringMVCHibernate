<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	h2{
	  font-family: arial, sans-serif;
	  border: 1px solid #F7E6FF;
	   background-color: #F7E6FF;
	  text-align: left;
	  padding: 8px;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #F7E6FF;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #F7E6FF;
	}
	</style>
<meta charset="ISO-8859-1">
<title>Current Balance</title>
</head>
<body>
<h2> Your current balance is ${balance}</h2>
<p><a href="${pageContext.request.contextPath}/customer/operations">Back</a></p>
</body>
</html>